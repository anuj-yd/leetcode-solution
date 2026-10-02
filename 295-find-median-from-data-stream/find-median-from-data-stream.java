class MedianFinder {

    PriorityQueue<Integer> lmax;
    PriorityQueue<Integer> rmin;

    public MedianFinder() {

        lmax = new PriorityQueue<>(Collections.reverseOrder());
        rmin = new PriorityQueue<>();

    }
    
    public void addNum(int num) {

        if(lmax.isEmpty() || num<=lmax.peek()){
            lmax.offer(num);
        }else{
            rmin.offer(num);
        }

        if(lmax.size()-rmin.size()>1){
            rmin.offer(lmax.poll());
        }
        else if(rmin.size()>lmax.size()){
            lmax.offer(rmin.poll());
        }



        
    }
    
    public double findMedian() {

        if(lmax.size() == rmin.size()){
            return (lmax.peek()+rmin.peek())/2.0;
        }

        return 1.0*lmax.peek();
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */