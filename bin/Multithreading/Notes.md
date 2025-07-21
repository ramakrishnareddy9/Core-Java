The cpu often referred as the brain of the computer, is responsible for executing instruction from programs. It performs basic arithmetic ,logic ,control ,and input/ output operations specified by the instructuions
A core is an individual processing unit within a cpu. Modern cpus can have multiple cores, allowing them to perform multiple tasks simultaneously
A program is a set of instructions written in a programming language that tells the computer how to perform a specific task

Process : is an instance of a program that is being executed. when a program runs, the os creates a process to manage its execution

Thread : a thread is the unit of execution within a process. A process can have multiple threads which shares the same resource but can independently.
eg : a web browser like google chrome might use multiple threads for different tab, with each tab running as a seperate thread

Multitasking allows an operating system to run multiple processes simutaneously. on single core cpu, this is done througt time sharing, rapidly switching between tasks. on multi core CPU's true parallel execution occurs, with tasks distributed across cores. the OS scheduler balances the load, ensuring efficient and responsive system performance.
Multitasking utilizes the capabilities of s cpu and its cores. when an operating system performs multitasking, it can assign different tasks to different cores. this is more efficient than assigning all tasks to a single core 

Multithreading : refers to the ablity to execute multiple thread within a single process concurrently.
In a web browser can use multithreading by having seperate threads for rendering the page ,running js, and managing user inputs. this makes the browser more responsive and efficient.
Multithreading enhances the efficiency of multitasking by breaking down individual tasks into smaller sub-tasks or threaads. these threads can be processed simunltaneously, making better use of the cpu's capablities.
In a single-core system : Both threads and processes are managed by the os scheduler through time slicing and context switching to create the illusion of simultaneous excution.
In a multi-core system : both threads and processes can be run in true parallel on different cores , with the OS scheduler distributing tasks across the cores to optimize performance.

Time Slicing : divides the cpu into small intervals called time slices or quanta.
Functions :- the os scheduler allocates these time sclice to different processes and threads, ensuring each gets a fair share of cpu time.
purpose :- this prevents any single process or thread from monopolizing the cpu, improving responsiveness and emabling concurrent execution.

Context Switching : is the process of saving the state of a currently running process or thread and loading the state of the next one to be executed.
Function :- when a process or thread time slice expires, the os scheduler performs a context switch a move the cpu focus to another process or thread.
purpose :- this allows multiple processes and thread to share to share the cpu giving the apperance of simultaneous executing on a single-core CPU or improving parallelism on multi-core CPUs.

Multitasking can be achieved through multithreading where each task is divided into threads that are managed concurrently.
While multitasking typically refers to the running of multiple applications, multithreading is more granular, dealing with multiple threads within the same app or process.
Multitasking operates at the level of processes , which are the operating system primary unit of execution.
Multithreading operates at the level of threads, which are smaller units within a process
Multitasking involves managing resources between completely separate programs, which may have independent memory spaces and system resources.
Multithreading involves managing resources within a single program, where threads share the same memory and resources.

In a single-core environment, Java's multithreading is managed by the JVM and the OS, which switch between threads to give the illusion of concurrency.
The threads share the single core, and time-slicing is used to manage thread execution.
In a multi-core environment, Java's multithreading can take full advantage of the available cores.
The JVM can distribute threads across multiple cores, allowing true parallel execution of threads.

A thread is a lightweight process, the smallest unit of processing. Java supports multithreading through its java.lang.Thread class and the java.lang.Runnable interface.

When a java program starts, one thread begins running immediately, which is called main thread. this thread is responsible for executing the main method of a program.


Life Cycle: 
NEW :
A thread is in this state after it is created (using new Thread(...)) but before the start() method is called.
It hasn't started executing yet.

RUNNABLE :
After start() is called, the thread moves to the RUNNABLE state.
It is ready to run and is waiting to be selected by the thread scheduler.
This includes both ready-to-run and actively-running threads.
RUNNING is not a separate state in Thread.State; it's internally part of RUNNABLE.

RUNNING (Not in Thread.State, but a logical substate) :
The thread is actually executing on the CPU.
Internally part of RUNNABLE. You cannot detect this state via getState().

BLOCKED / WAITING / TIMED_WAITING :
State	            When it Happens	                            Example Code
BLOCKED	            Waiting to acquire a monitor lock	        Another thread is in a synchronized block
WAITING	Waiting     indefinitely for another thread	            join(), wait() (no timeout)
TIMED_WAITING	    Waiting for a limited time	                sleep(1000), join(500), wait(1000)

TERMINATED :
A thread reaches this state when its run() method finishes or if it terminates due to an uncaught exception.
Also called the "Dead" state.

Thread Methods:

start() : Begins the execution of a new thread.
Internally calls the run() method on a separate call stack (new thread).

sleep() : Pauses the current thread for a given time (in milliseconds).
Useful for delaying execution or simulating work.
then Thread enters TIMED_WAITING state.

join() : Pauses the current thread until another thread finishes its execution.
then Current thread enters WAITING or TIMED_WAITING state.

setPriority() : Sets the priority level of a thread (between 1 and 10).
| Constant               | Value | Meaning          |
| ---------------------- | ----- | ---------------- |
| `Thread.MIN_PRIORITY`  | 1     | Lowest priority  |
| `Thread.NORM_PRIORITY` | 5     | Default priority |
| `Thread.MAX_PRIORITY`  | 10    | Highest priority |
llegalArgumentException if the value is not between 1 and 10.

getPriority() : Returns the current priority of a thread.

yield() : method is a static method in the Thread class that is used to suggest to the thread scheduler that the current thread is willing to pause and let other threads of equal or higher priority run.
yield() does not guarantee that another thread will run — it’s just a hint to the scheduler.
The JVM/OS scheduler may ignore the hint.

User Threads are normal threads created by your application code to perform tasks in parallel with the main program.
JVM does not exit until all user threads finish

A daemon thread is a background service thread that runs in the JVM to support other user threads.
The JVM exits automatically when only daemon threads are left running.
Provide background services (e.g., garbage collection, cleanup tasks, Watchdog, Auto-Save Threads (in IDEs))
JVM will exit automatically when only daemon threads are running

Synchronization : is a mechanism that controls access to shared resources in multithreading, ensuring that only one thread can access the critical section at a time. It prevents problems like race conditions and data inconsistency.

critical section : is the part of your program where shared resources (like variables, objects, or files) are accessed or modified by multiple threads.
If two or more threads access a shared resource simultaneously, and at least one of them writes to it, it can lead to race conditions and data inconsistency.
only one thread enter the into the critical section at once

Intrinsic lock : these are biuld into every object in java. you dont's see them but they are there. When you use synchronized keyword or block you are using these locks automatically 

Explicit lock : these are more advanced locks you can control yourself the Lock class form java.util.concurrent.locks . YOu explicitly say when to lock and unlock, giving you more control over how and when people can write the notebook.They give you more advanced control over locking behavior compared to synchronized (intrinsic locks).With explicit locks, you manually acquire and release the lock using lock() and unlock() methods.

Lock(Interface) : is a interface in Java is part of the java.util.concurrent.locks package and provides a more flexible and powerful alternative to the synchronized keyword.

Method                       Description                                                              

`void lock()`               Acquires the lock (waits if already held) 

`void unlock()`             Releases the lock  
                                                    
`boolean tryLock()`         Tries to acquire the lock **without waiting**      

`boolean tryLock(long time, TimeUnit unit)` Waits for a limited time to acquire the lock    
note: use IntrreputedException                             

`void lockInterruptibly()`  Acquires the lock, but allows the thread to be interrupted while waiting |

ReentrantLock(class) : is a class from java.util.concurrent.locks package that provides explicit locking similar to the synchronized keyword — but with more flexibility, power, and control.
Reentrant means that the same thread can acquire the lock multiple times without getting blocked.

| Method                    | Description                                                      |
| ------------------------- | ---------------------------------------------------------------- |
| `lock()`                  | Acquires the lock. Waits indefinitely if not available.          |
| `unlock()`                | Releases the lock.                                               |
| `tryLock()`               | Tries to acquire lock **without waiting**.                       |
| `tryLock(time, unit)`     | Waits for a specified time to acquire the lock.                  |
| `isLocked()`              | Checks if the lock is currently held by any thread.              |
| `isHeldByCurrentThread()` | Checks if current thread holds the lock.                         |
| `getHoldCount()`          | Returns how many times the current thread has acquired the lock. |
| `isFair()`                | Returns whether it’s a fair lock (FIFO).                         |

| Feature               | `ReentrantLock`            | `synchronized`|
| --------------------- | -------------------------  | --------------|
| Reentrant             |  Yes                       |  Yes          |
| Fairness              |  Optional (`true`)         |  No control   |
| Try-lock with timeout |  Yes                       |  No           |
| Interruptible lock    |  Yes                       |  No           |
| Explicit lock/unlock  |  Yes (`lock()`/`unlock()`) |  Automatic    |
| Condition support     |  Yes (`newCondition()`)    |  No           |

ReadWriteLock(Interface) : is an advanced locking mechanism in Java that allows:
-> Multiple threads to read shared data at the same time (when no thread is writing).
-> Only one thread to write, and while writing, no other thread can read or write.
When do we use :
-> You have a read-heavy workload (many readers, few writers).
-> You want better concurrency than synchronized or ReentrantLock.

ReentrantReadWriteLock(class) : is a concrete implementation of the ReadWriteLock interface in Java. It provides two locks:
readLock() → For shared read access
writeLock() → For exclusive write access
It allows Multiple threads to read simultaneously, But only one thread to write, and no reads are allowed during writing

DeadLock : is asituation in multithreading where two or more threads are blocked forever , waiting fo reach other to release a resource. this typically occurs when two or more threads have circular dependencies on a set of locks.
DeadLock types:
Mutual Exclusion : Only one thread can access a resource at a time.
Hold and Wait : A thread holding at least one resource is waithing to acquire additional resources held by other threads.
No Preemption : Resources cannot be forced taken from thread holding them.
Circular Wait : A set of threads is waithing for each other in a circular chain.




advance :
Executors (thread pools)

Callable, Future

CountDownLatch, Semaphore, CyclicBarrier

 advanced synchronization tools like  Semaphore, monitors, or wait/notify next?

 import java.util.concurrent.locks.*; classes in it