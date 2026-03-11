class ZeroEvenOdd {
    private int n;
    Semaphore zero, o, e;
    public ZeroEvenOdd(int n) {
        this.n = n;
        zero = new Semaphore(1);
        o = new Semaphore(0);
        e=new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=1;i<=n;i++){
            zero.acquire();
            printNumber.accept(0);
             if (i % 2 == 0) {
                e.release();
            } else {
                o.release();
            }
        }
      
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i<=n; i=i+2) {
            e.acquire();
            printNumber.accept(i);
            zero.release();
        }
       
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i<=n; i=i+2) {
            o.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }
}