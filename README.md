Copyright Adrian Popescu
# Orders-Processing-Threading-Project-Java
  This project focuses on implementing parallelization in Java to efficiently deliver products and mark orders as completed. To handle orders, the size of the input file in bytes was determined, and an approximate number of lines were calculated. Depending on the number of threads, each worker was assigned a unique set of orders to process. The process management was facilitated by a thread pool, initiating these level-one threads.
Within a level-one thread, the lines of the order file were traversed until reaching the designated section for which the respective worker was responsible. Data was extracted from the necessary lines, and level-two threads were started to process each individual product in the orders. To ensure that a maximum of P threads runs in parallel at this level, a fixed thread pool was again employed. Thus, N threads were started for each order, where N is the number of products in that order, limited and processed by the executor service. To ensure that a thread searches for an individual product, a unique ID marking the product number to be delivered was sent. Then, in the level-two threads, the product was searched line by line. Upon finding it, the delivery notification for the respective order was written to the product output file. This way, after a notification causes the number of products delivered for a specific order to be complete, the result is displayed in the order output file.

## While the current task was a bit challenging to comprehend, it provided valuable educational insights overall.

# Features
* Parallelized Order Processing: Utilized Java parallelization to concurrently process and deliver products, improving efficiency.
* File Size Analysis: Determined the size of the input file in bytes and approximated the number of lines for efficient order processing.
* Multithreaded Approach: Employed a thread pool for both level-one and level-two threads to manage and execute tasks concurrently.
* Product Notification System: Implemented a notification system to mark products as delivered and update order output files accordingly.
* Educational Focus: Designed as an educational project to provide insights into parallelization and multithreading in Java.

# Technologies Used
* Java
* Multithreading
* Thread Pools
* File Handling
