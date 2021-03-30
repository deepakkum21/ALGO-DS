class MinBinaryHeap {
    constructor(){
        this.values = [];
    }
    insert(element){
        this.values.push(element);
        this.bubbleUp();
    }
    bubbleUp(){
        let idx = this.values.length - 1;
        const element = this.values[idx];
        while(idx > 0){
            let parentIdx = Math.floor((idx - 1)/2);
            let parent = this.values[parentIdx];
			
			// main diff between max and min heap is the below line
            if(element >= parent) break;
            this.values[parentIdx] = element;
            this.values[idx] = parent;
            idx = parentIdx;
        }
    }
	
	extractMin(){
		const max = this.values[0];
		const end = this.values.pop();
		
		if(this.values.length >  0 ) {
			this.values[0] = end;
			this.sinkDown();
		}
		
		return max;
	}
	
	sinkDown() {
		let idx=0;
		const length = this.values.length;
		const element = this.values[0];
		
		while(true) {
			let leftChildIndex = 2 * idx +1;
			let rightChildIndex = 2 * idx +2;
			let leftChild, rightChild;
			
			let swap = null;
			
			// check for outOfBounds index for rightChildIndex and leftChildIndex
			if(leftChildIndex < length) {
				leftChild = this.values[leftChildIndex];
				if(leftChild < element) {
					swap = leftChildIndex;
				}
			}
			if(rightChildIndex < length) {
				rightChild = this.values[rightChildIndex];
				if(
					( swap === null && rightChild < element) || 
					(swap !== null && rightChild < leftChild)
				  ) {
					swap = rightChildIndex;
				}
			}
			
			if(swap===null) break;
			
			this.values[idx] = this.values[swap];
			this.values[swap] = element;
			idx = swap; 
		}
	}
}

let heap = new MinBinaryHeap();
heap.insert(41);
heap.insert(39);
heap.insert(33);
heap.insert(18);
heap.insert(27);
heap.insert(12);
heap.insert(55);
