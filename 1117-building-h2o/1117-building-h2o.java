class H2O {

    Semaphore h1,h2,o;
    public H2O() {
        h1=new Semaphore(2);
        o=new Semaphore(0);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		h1.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        o.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
        h1.release(2);
    }
}