class H2O {

    private Semaphore h = new Semaphore(2);
    private Semaphore o = new Semaphore(1);
    private Semaphore d = new Semaphore(0);
    public H2O() {    
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        // releaseHydrogen.run() outputs "H". Do not change or remove this line
        // do hydrogen if allowed
        h.acquire();
        releaseHydrogen.run();
        d.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        
        // releaseOxygen.run() outputs "O". Do not change or remove this line.

        // do oxygen if allowed
        o.acquire();
		releaseOxygen.run();
        // wait till hydrogen is all done
        d.acquire();
        d.acquire();

        //reset for next
        h.release(2);
        o.release();
    }
}