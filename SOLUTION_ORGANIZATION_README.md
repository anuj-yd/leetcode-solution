# LeetCode Solutions Repository - Organized by Topic 🎯

Organized collection of LeetCode solutions automatically categorized by problem topics.

## 📁 Structure

Solutions are organized in the following directory:
```
Solutions/
├── array/
├── linked-list/
├── string/
├── tree/
├── graph/
├── dynamic-programming/
├── sorting/
├── bit-manipulation/
├── math/
├── hash-table/
├── stack/
├── queue/
├── heap/
├── greedy/
└── miscellaneous/
```

## 🤖 How It Works

1. **Original Solutions** - All problem folders (`1-two-sum`, `2-add-two-numbers`, etc.) remain in the root directory
2. **Symbolic Links** - Topic-based directories contain symbolic links to the original solution folders
3. **No Duplicates** - No files are copied or deleted - only links are created
4. **Auto-Sync** - GitHub Actions automatically organizes new solutions when pushed

## 📊 Statistics

- **Total Topics**: 16
- **Problems Mapped**: 900+
- **Organization**: Automatic on every push
- **Data Loss**: Zero (no files deleted/moved)

## 🚀 Quick Start

Navigate to any topic folder to view solutions:

```bash
cd Solutions/dynamic-programming
# View all DP solutions
ls
```

## 🔄 Automatic Organization

When you push new solutions:
1. GitHub Actions triggers automatically
2. `organize_solutions.py` runs and categorizes solutions
3. New symlinks are created in topic folders
4. Changes are auto-committed to main

**No manual intervention needed!** Just push your solutions and they'll be organized automatically.

## 📝 Adding New Solutions

1. Create a new folder: `PROBLEM_ID-problem-name`
2. Add your solution file(s)
3. Push to the repository
4. Workflow automatically organizes it by topic

Example:
```bash
mkdir 2500-delete-greatest-common-divisors-in-linked-list
# Add solution file
git add .
git commit -m "Add solution for problem 2500"
git push
```

The solution will automatically appear in the appropriate topic folder!

## 🏷️ Topic Categories

| Topic | Count | Examples |
|-------|-------|----------|
| Array | 200+ | Two Sum, Merge Intervals, Rotate Array |
| Dynamic Programming | 180+ | House Robber, Coin Change, Edit Distance |
| Linked List | 80+ | Reverse List, Merge K Lists |
| String | 150+ | LCS, Regular Expression Matching |
| Tree | 120+ | BST, BFS, DFS Traversals |
| Graph | 70+ | BFS, DFS, Dijkstra, Union Find |
| Sorting | 40+ | Quick Sort, Merge Sort, Counting Sort |
| Hash Table | 150+ | HashMap, HashSet problems |
| Stack | 50+ | Parentheses, LRU Cache |
| Queue | 20+ | BFS, Level Order Traversal |
| Heap | 30+ | Priority Queue, Kth Largest |
| Bit Manipulation | 40+ | XOR, Bit Shifting, Bit Masking |
| Math | 100+ | GCD, Prime Numbers, Geometry |
| Greedy | 60+ | Activity Selection, Huffman Coding |
| Miscellaneous | Varies | Other categorizations |

## 🔗 What's a Symlink?

A symbolic link is like a "shortcut" that points to the original file/folder without duplicating it. Benefits:
- ✅ No storage overhead
- ✅ Original files stay in root
- ✅ No version conflicts
- ✅ Easy to move/rename originals

## 📚 Useful Commands

```bash
# See all solutions in a topic
ls Solutions/dynamic-programming

# See original problem folder
ls 1-two-sum

# Follow the symlink to see original files
cd Solutions/array/1-two-sum
cat Solution.java  # Shows content from root/1-two-sum/Solution.java

# Check if it's a symlink
ls -l Solutions/array/1-two-sum
# Output: Solutions/array/1-two-sum -> ../../1-two-sum
```

## 🛠️ Manual Organization (Optional)

If you want to manually organize without waiting for workflow:

```bash
python organize_solutions.py .
```

This runs the same categorization script and creates all symlinks.

## 📞 How to Use

1. **Browse by Topic** - Go to `Solutions/[topic]/` folder
2. **View Details** - Each solution is linked to its original folder with problem description
3. **Check Index** - View `Solutions/INDEX.json` for complete mapping

## ⚙️ Configuration

Topic mappings are defined in `organize_solutions.py`. To add more problems to a topic or create new topics, edit the `TOPIC_MAP` dictionary.

## 🎓 Benefits

- 📦 Better code organization
- 🔍 Easy to find solutions by topic
- 📈 Helps with interview preparation  
- 🧠 Group related problems together for learning patterns
- 🚀 Scales automatically as you add more solutions

---

**Keep solving, stay organized!** 🎯
