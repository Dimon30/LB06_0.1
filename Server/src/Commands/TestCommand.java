package Commands;

public class TestCommand extends Command{
    private String name = "testCommand";
    private String description = "description";
    public TestCommand getTestCommand(){
        TestCommand t = new TestCommand();
        return t;
    }
    @Override
    public String getName(){return this.name;}
}
