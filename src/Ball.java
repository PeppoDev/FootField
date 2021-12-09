
class Ball {
    private Children children;

    public Ball() {

    }

    public void setChildren(Children children) {
        synchronized (this) {
            while (this.children != null)
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            this.children = children;

            System.out.println("A criança " + this.children.getName() + " pegou a bola");

            try {
                Thread.sleep(children.getSkillInMili());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("A criança " + this.children.getName() + " perdeu a bola");

            this.children = null;
            notifyAll();
        }
    }

}