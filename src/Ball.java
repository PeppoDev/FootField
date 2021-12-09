// public class Ball {
//     private ChildrenBKP possessor;

//     public void setPossessor(ChildrenBKP newPocessor) {
//         if (possessor == null) {
//             synchronized (this) {
//                 this.possessor = newPocessor;

//                 try {
//                     Thread.sleep(this.possessor.getSkillInMili());
//                 } catch (InterruptedException e) {
//                     e.printStackTrace();
//                 }

//                 this.possessor.loseBall();
//                 setPocessorNull();
//                 notifyAll();
//             }
//         } else {
//             synchronized (this) {
//                 try {
//                     System.out.println("bateu aqui");
//                     wait();
//                 } catch (InterruptedException e) {
//                     e.printStackTrace();
//                 }
//             }
//         }
//     }

//     public void setPocessorNull() {
//         this.possessor = null;
//     }

// }

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