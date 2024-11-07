package c_reflect.test02.dogclass;

public class Dog extends Animal implements I1, I2 {
    private  int mDogPrivate;
    public int mDogPublic;
    protected int mDogPubluc;

    @Override
    public String toString() {
        return "Dog{" +
                "mDogPrivate=" + mDogPrivate +
                ", mDogPublic=" + mDogPublic +
                ", mDogPubluc=" + mDogPubluc +
                ", mAinimalProtected=" + mAinimalProtected +
                ", mAnimalDefault=" + mAnimalDefault +
                ", mAnimalPublic=" + mAnimalPublic +
                ", mCellPublic=" + mCellPublic +
                '}';
    }
}
