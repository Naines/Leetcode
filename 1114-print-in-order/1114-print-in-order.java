class Foo {
     Semaphore run1,run2;
    public Foo() {
        run1 = new Semaphore(0);
        run2 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException{
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        run1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        run1.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        run2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        run2.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}