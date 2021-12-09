
public class Children implements Runnable {
    private String name;
    private Ball ball;
    private int skill;
    private Thread t;

    public Children(String name, Ball ball) {
        this.name = name;
        this.ball = ball;

        this.skill = this.generateSkill();

        this.t = new Thread(this, name);
        this.t.setPriority(this.skill);
    }

    public String getName() {
        return this.name;
    }

    public void start() {
        this.t.start();

    }

    public int getSkillInMili() {
        return this.skill * 1000;
    }

    public int generateSkill() {
        // in seconds
        double a = Math.floor(Math.random() * (10 - 3 + 1) + 3);
        return (int) a;
    }

    @Override
    public void run() {
        System.out.println("Criança " + this.name + " tentou pegar a bola com prioridade de: " + this.skill);
        this.ball.setChildren(this);
    }
}
