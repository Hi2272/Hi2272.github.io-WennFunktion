public class Webshop {

   private Artikel[] art;


   public Webshop() {
      this.art = new Artikel[10];
      for (int i = 0; i < art.length; i++) {
         this.art[i] = new Artikel(i, "Turnschuh", Math.round(59.95 + Math.random() * 100) + 0.95);
      }
   }

   public void loesche(int index) {
      if(index >= 0 && index < getLaenge()) {
         for (int i = index; i < getLaenge() - 1; i++) {
            this.art[i] = this.art[i + 1];
         }
         this.art[getLaenge() - 1] = null;
      } else {
         println("Fehler, der index ist zu groß oder zu klein.");
      }
   }
   
   public void sortiere() {
      int anz = getLaenge();
      for (int i = 0; i < anz; i++) {
         int min = getIndexOfCheapest(i, anz);
         swap(i, min);
      }
   }

   public int getLaenge() {
      int i = 0;
      while (art[i] != null) {
         i = i + 1;
         if(i == art.length) {
            return i;
         }
      }
      return i;
   }
   
   public void printAlles() {
      for (int i = 0; i < getLaenge(); i++) {
         this.art[i].drucken();
      }
   }


   public int getIndexOfCheapest(int start, int ende) {
      int index = start;
      for (int i = start; i < ende; i++) {
         if(art[i].getPreis() < art[index].getPreis()) {
            index = i;
         }
      }
      return index;
   }

   public void printCheapest() {
      art[getIndexOfCheapest(0, getLaenge())].drucken();
   }

   public void swap(int index1, int index2) {
      Artikel a = art[index1];
      art[index1] = art[index2];
      art[index2] = a;
   }

}

Webshop w = new Webshop();
w.printAlles();
println("--------------");
w.loesche(4);
w.printAlles();