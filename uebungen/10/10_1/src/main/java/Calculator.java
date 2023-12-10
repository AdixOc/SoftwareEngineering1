import java.util.LinkedList;
import java.util.List;

public class Calculator {
    List<OperationCommand> operations;
    float result;
    int pointer;

    public Calculator() {
        operations = new LinkedList<>();
        result = 0;
        pointer = 0;
    }

    public void addOperation(OperationCommand op){
        if (pointer == operations.size()) {
            operations.add(op);
        } else {
            // remove all operations after the pointer
            operations.subList(pointer, operations.size()).clear();
            operations.add(pointer, op);
        }
        operations.add(op);
        pointer++;
    }

    public float doCalc(){
        this.result = 0;
        for(int i = 0; i < pointer; ++i){
            operations.get(i).execute();
        }
        return result;
    }

    public void undo() {
        if (pointer > 0) {
            pointer--;
        }
    }

    public void redo() {
        if (pointer < operations.size()) {
            pointer++;
        }
    }

    public String toString(){
        doCalc();
        return "Result: " + result;
    }
}
