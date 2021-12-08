public class Ball {
    private Children possessor;

    synchronized public void setPossessor(Children newPocessor) {
        if (possessor == null) {
            this.possessor = newPocessor;

            try {
                Thread.sleep(this.possessor.getSkillInMili());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.possessor.loseBall();
            setPocessorNull();
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setPocessorNull() {
        this.possessor = null;
    }

}
