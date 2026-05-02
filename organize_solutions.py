#!/usr/bin/env python3
"""
organize_solutions.py

Scans the repository root for LeetCode problem folders (folders that start with a problem number
like "1-two-sum") and creates a topic-based directory structure under `Solutions/` containing
symbolic links that point back to the original folders.

- Does NOT move or delete original folders/files.
- Creates relative symbolic links so the repository size does not increase.
- Generates `Solutions/INDEX.json` with a mapping of topics -> problems and a flat problems list.

Usage:
    python organize_solutions.py [repo_root]

Example:
    python organize_solutions.py .

This script is written to be POSIX-friendly (Linux/macOS). On systems that don't allow symlinks
(or without permission) the script will create a small ``.symlink`` pointer file instead of a
real symlink (so no duplication of the full solution contents).
"""

import os
import re
import json
import sys
from pathlib import Path

# Basic topic keyword map. This is intentionally conservative and easy to extend.
TOPIC_KEYWORDS = {
    "array": ["array", "two-sum", "merge", "rotate", "subarray", "sliding", "product", "duplicate", "intersection"],
    "string": ["string", "palindrome", "substring", "anagram", "word", "regex", "substring", "license", "ransom"],
    "linked-list": ["list", "linked", "node", "merge-k", "odd-even", "reverse-n", "middle"],
    "tree": ["tree", "bst", "binary", "preorder", "inorder", "postorder", "leaf", "ancestor", "traversal", "serialize"],
    "graph": ["graph", "course", "islands", "network", "dijkstra", "bipartite", "province"],
    "dynamic-programming": ["triangle", "climb", "robber", "coin", "partition", "dp", "maximum-subarray", "minimum-cost", "subsequence"],
    "sorting": ["sort", "merge-sort", "quick", "kth-largest", "heap", "maximum-sort"],
    "hash-table": ["hash", "map", "set", "anagram", "contains-duplicate", "find"],
    "stack": ["stack", "valid-parentheses", "reverse-polish", "asteroid", "largest-rectangle"],
    "queue": ["queue", "bfs", "level-order"],
    "heap": ["heap", "priority", "kth-largest", "maximum-product"],
    "bit-manipulation": ["bit", "xor", "power", "ones-and-zeroes", "single-number"],
    "math": ["gcd", "prime", "pow", "add-digits", "perfect-number"],
    "greedy": ["greedy", "interval", "activity", "jump", "minimum"],
    "backtracking": ["n-queens", "subsets", "generate-parentheses", "backtracking"],
    "miscellaneous": []
}

PROBLEM_DIR_RE = re.compile(r"^\d+[-_].+")


def detect_topic(folder_name: str):
    name = folder_name.lower()
    # Try keyword matching
    for topic, keywords in TOPIC_KEYWORDS.items():
        for kw in keywords:
            if kw in name:
                return topic
    # fallback heuristics
    if "list" in name or "linked" in name:
        return "linked-list"
    if "tree" in name or "bst" in name:
        return "tree"
    if "graph" in name:
        return "graph"
    if "dp" in name or "dynamic" in name:
        return "dynamic-programming"
    if "string" in name or "palin" in name:
        return "string"
    if "sort" in name or "merge" in name:
        return "sorting"
    return "miscellaneous"


def make_relative_target(problem_folder: Path, link_parent: Path):
    # returns a POSIX-style relative path string from link_parent to problem_folder
    try:
        rel = os.path.relpath(problem_folder, start=link_parent)
    except Exception:
        # fallback
        rel = os.path.join('..', problem_folder.name)
    return rel


def ensure_dir(p: Path):
    if not p.exists():
        p.mkdir(parents=True, exist_ok=True)


def create_symlink_or_pointer(target: str, link_path: Path):
    # target: relative target path string
    # link_path: full path for the symlink to create
    if link_path.exists() or link_path.is_symlink():
        # if existing symlink points to same target, skip
        if link_path.is_symlink():
            try:
                current = os.readlink(link_path)
                if current == target:
                    return True
                else:
                    link_path.unlink()
            except OSError:
                try:
                    link_path.unlink()
                except Exception:
                    pass
        else:
            # It's a real file/dir that we shouldn't overwrite
            return False

    # Try to create real symlink
    try:
        os.symlink(target, link_path)
        return True
    except (OSError, NotImplementedError) as e:
        # Fallback: create a small pointer file with .symlink extension
        try:
            with open(str(link_path) + ".symlink", "w") as f:
                f.write(target + "\n")
            return True
        except Exception:
            return False


def main(root_path: str = "."):
    root = Path(root_path).resolve()
    os.chdir(root)

    all_entries = [p for p in root.iterdir() if p.is_dir()]

    problem_folders = [p.name for p in all_entries if PROBLEM_DIR_RE.match(p.name)]

    if not problem_folders:
        print("No problem folders found in repo root (pattern: '123-problem-name'). Exiting.")
        return 0

    solutions_dir = root / "Solutions"
    ensure_dir(solutions_dir)

    index = {
        "topics": {},
        "problems": sorted(problem_folders)
    }

    for folder in sorted(problem_folders):
        topic = detect_topic(folder)
        topic_dir = solutions_dir / topic
        ensure_dir(topic_dir)

        problem_folder = root / folder
        # create a relative symlink from topic_dir/<folder> -> ../../<folder> (or appropriate relpath)
        link_path = topic_dir / folder
        rel_target = make_relative_target(problem_folder, link_path.parent)

        success = create_symlink_or_pointer(rel_target, link_path)
        if not success:
            print(f"Warning: Could not create link for {folder} -> {rel_target}")

        index.setdefault("topics", {}).setdefault(topic, []).append(folder)

    # sort topic lists for consistent output
    for t, lst in index["topics"].items():
        index["topics"][t] = sorted(lst)

    with open(solutions_dir / "INDEX.json", "w") as f:
        json.dump(index, f, indent=2)

    # Print summary
    print("Organization complete.")
    print(f"Topics: {len(index['topics'])}")
    total = sum(len(v) for v in index['topics'].values())
    print(f"Problems linked: {total}")

    return 0


if __name__ == "__main__":
    root_arg = sys.argv[1] if len(sys.argv) > 1 else "."
    sys.exit(main(root_arg))
