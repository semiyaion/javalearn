package blocking;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

public class Test implements BlockingDeque {
    //阻塞队列
    /*方法
     * blockingqueue继承queue接口，所以也有queue接口中的基本操作
     * 1.插入元素：
     * 1)add ；将元素插入队列尾部，如果队列已满，抛出异常
     * 2）offer：将元素插入队列末尾，如果已满，返回false
     * 3.put：将元素插入末尾，若已满，则一直阻塞直到有空间
     * 4）offer（e，timeout，timeunit）将指定元素插入此队，若已满，则等待指定时间直到队列可用
     * 2.删除：
     * poll：检查并删除此队列的头部，如果为空则返回null
     * remove：检索但不删除此队列的头部，如果为空，则返回null
     * 3.查找
     * E element（）检索但不删除此队列的头部，如果为空则抛出异常
     * peek：检索但不删除队列头部，如果为空则返回null
     * 4.删除
     * 1。take：检索并删除此队列的头部，如果有必要则等待直到队列可用
     * 2.poll（longtime，timeunit）：检索并删除队列头部，如果需要元素可用，则等待指定的等待时间*/



    /*接口中实现的类
     * ArrayBlockingQueue
     * 1.有界2.先进先出3.队列满的时候放入会阻塞，从空队列中取出元素也会阻塞*/

    @Override
    public void addFirst(Object o) {

    }

    @Override
    public void addLast(Object o) {

    }

    @Override
    public boolean offerFirst(Object o) {
        return false;
    }

    @Override
    public boolean offerLast(Object o) {
        return false;
    }

    @Override
    public Object removeFirst() {
        return null;
    }

    @Override
    public Object removeLast() {
        return null;
    }

    @Override
    public Object pollFirst() {
        return null;
    }

    @Override
    public Object pollLast() {
        return null;
    }

    @Override
    public Object getFirst() {
        return null;
    }

    @Override
    public Object getLast() {
        return null;
    }

    @Override
    public Object peekFirst() {
        return null;
    }

    @Override
    public Object peekLast() {
        return null;
    }

    @Override
    public void putFirst(Object o) throws InterruptedException {

    }

    @Override
    public void putLast(Object o) throws InterruptedException {

    }

    @Override
    public boolean offerFirst(Object o, long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public boolean offerLast(Object o, long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Object takeFirst() throws InterruptedException {
        return null;
    }

    @Override
    public Object takeLast() throws InterruptedException {
        return null;
    }

    @Override
    public Object pollFirst(long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public Object pollLast(long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean offer(Object o) {
        return false;
    }

    @Override
    public void put(Object o) throws InterruptedException {

    }

    @Override
    public boolean offer(Object o, long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Object remove() {
        return null;
    }

    @Override
    public Object poll() {
        return null;
    }

    @Override
    public Object take() throws InterruptedException {
        return null;
    }

    @Override
    public Object poll(long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public int remainingCapacity() {
        return 0;
    }

    @Override
    public Object element() {
        return null;
    }

    @Override
    public Object peek() {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int drainTo(Collection c) {
        return 0;
    }

    @Override
    public int drainTo(Collection c, int maxElements) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public Iterator descendingIterator() {
        return null;
    }

    @Override
    public void push(Object o) {

    }

    @Override
    public Object pop() {
        return null;
    }
}
