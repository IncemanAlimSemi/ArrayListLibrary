public class ArrayList<T> {
    private Object[] data;
    private int size;

    public ArrayList() {
        data = new Object[1];
        size = 0;
    }


    public int getSize(){
        return data.length;
    }

    public void add(T T) {
        ensureCapacity(size + 1);
        data[size++] = T;
    }

    public void add(int index, T T){
        rangeCheckForAdd(index);
        int i = 0;
        Object[] tempData = new Object[size + 1];

        for (Object rData: data) {
            if(i < index){
                tempData[i] = rData;
            }else {
                tempData[i+1] = rData;
            }
            i++;
        }
        tempData[index] = T;
        data = new Object[size++ + 1];
        changeItems(data, tempData);
    }

    public void remove(int index) {
        rangeCheck(index);
        separateData(index);
        size--;
    }

    public void remove(Object object){
        for (int index = 0; index < size; index++) {
            if(object == data[index]){
                separateData(index);
                break;
            }
        }
        size--;
    }

    private void separateData(int index){
        int i = 0, j = 0;
        Object[] firstTempData = new Object[index];
        Object[] secondTempData = new Object[getSize() - (index+1)];

        for (Object object: data){
            if (i < index){
                firstTempData[j] = object;
                j++;
            }else if (i > index){
                secondTempData[j] = object;
                j++;
            }else {
                j = 0;
            }
            i++;
        }
        mergeData(firstTempData, secondTempData);
    }

    private void mergeData(Object[] firstTempData, Object[] secondTempData){
        data = new Object[getSize() - 1];
        int j = 0;
        for (int i = 0; i < getSize(); i++) {
            if (i < firstTempData.length){
                data[i] = firstTempData[j];
            }else if (i == firstTempData.length){
                j = 0;
                data[i] = secondTempData[j];
            }else {
                data[i] = secondTempData[j];
            }
            j++;
        }
    }

    private void ensureCapacity(int minCapacity){
        int oldCapacity = getSize();
        if (oldCapacity < minCapacity){
            copyOf(minCapacity, oldCapacity);
        }
    }

    private void rangeCheck(int index){
        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private void rangeCheckForAdd(int index){
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    private void copyOf(int newCapacity, int oldCapacity){
        Object[] tempData = new Object[oldCapacity];
        changeItems(tempData, data);
        data = new Object[newCapacity];
        changeItems(data, tempData);
    }

    private void changeItems(Object[] source, Object[] toBeCopied) {
        int index = 0;
        for (Object object: toBeCopied) {
            source[index++] = object;
        }
    }

    public void show(){
        for (Object object:data) {
            System.out.println(object);
        }
    }

    public String toString(){
        System.out.print("[");
        for (int i = 0; i < getSize(); i++) {
            if (i < getSize() - 1)
                System.out.print(data[i].toString() + ", ");
            else
                System.out.print(data[i].toString());
        }
        System.out.print("]");

        return "";
    }
}
