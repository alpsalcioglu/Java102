import java.util.List;
public class NumberProcessor implements Runnable{
    private List<Integer> numbers;
    private List<Integer> oddNumbers;
    private List<Integer> evenNumbers;

    public NumberProcessor(List<Integer> numbers, List<Integer> oddNumbers, List<Integer> evenNumbers) {
        this.numbers = numbers;
        this.oddNumbers = oddNumbers;
        this.evenNumbers = evenNumbers;
    }

    @Override
    public void run() {
        for (int number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            } else {
                oddNumbers.add(number);
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getOddNumbers() {
        return oddNumbers;
    }

    public void setOddNumbers(List<Integer> oddNumbers) {
        this.oddNumbers = oddNumbers;
    }

    public List<Integer> getEvenNumbers() {
        return evenNumbers;
    }

    public void setEvenNumbers(List<Integer> evenNumbers) {
        this.evenNumbers = evenNumbers;
    }
}
