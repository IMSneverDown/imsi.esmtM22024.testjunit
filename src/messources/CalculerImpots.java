package messources;
    public class CalculerImpots{

        public int calculerImpots(int salairebrut, int nombreparts) {
            if (nombreparts > 5)
                throw new IllegalArgumentException("Le nombre de parts doit être inférieur à 6");
            if (nombreparts == 0)
                throw new ArithmeticException("Le nombre de parts doit être supérieur à 0");
            return Integer.divideUnsigned(salairebrut, nombreparts);
        }
        public double calculerNombreParts(int nombreConjoints, String statutConjoint, int nombreEnfants) {
            double parts = 1.0; // Part pour l'employé

            if (nombreConjoints > 0) {
                if ("N".equalsIgnoreCase(statutConjoint)) {
                    parts += 0.5; // Conjoint non salarié
                }
            }
            parts += 0.5 * nombreEnfants;
            return Math.min(parts, 5.0);
        }

    }
