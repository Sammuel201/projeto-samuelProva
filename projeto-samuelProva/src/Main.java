import java.util.ArrayList;
import javax.swing.JOptionPane;

class Jogador {
    private String nome;
    private int votos;

    public Jogador(String nome) {
        this.nome = nome;
        this.votos = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getVotos() {
        return votos;
    }

    public void incrementaUmVoto() {
        this.votos++;
    }
}

public class CasaMaisVigiada {

    public static void main(String[] args) {
        ArrayList<Jogador> participantes = inicializarParticipantes();

        JOptionPane.showMessageDialog(null, "Bem-vindo à Casa Mais Vigiada do Brasil!");

        while (true) {
            String voto = JOptionPane.showInputDialog(null, "Vote em quem você deseja eliminar da casa (digite 'sair' para encerrar):");
            if (voto.equalsIgnoreCase("sair")) {
                break;
            } else {
                registrarVoto(participantes, voto);
            }
        }

        Jogador eliminado = encontrarEliminado(participantes);
        if (eliminado != null) {
            JOptionPane.showMessageDialog(null, "Se eu conseguir mover montanhas, se eu conseguir surfar um tsunami, se eu conseguir "
                    + "domar o sol, se eu conseguir fazer o mar virar sertão, e o sertão virar mar, se eu conseguir "
                    + "dizer o que eu nunca vou conseguir dizer, aí terá chegado o dia em que eu vou conseguir te "
                    + "eliminar com alegria. Com " + eliminado.getVotos() + " votos, é você quem sai " + eliminado.getNome());
        } else {
            JOptionPane.showMessageDialog(null, "Não houve eliminação nesta votação.");
        }
    }

    private static ArrayList<Jogador> inicializarParticipantes() {
        ArrayList<Jogador> participantes = new ArrayList<>();
        String[] nomes = {"Alane Dias", "Beatriz Reis", "Davi Brito", "Deniziane Ferreira", "Fernanda Bande",
                "Giovanna Lima", "Giovanna Pitel", "Isabelle Nogueira", "Juninho", "Leidy Elin",
                "Lucas Henrique", "Lucas Luigi", "Lucas Pizane", "Marcus Vinicius", "Matteus Amaral",
                "Maycon Cosmer", "MC Bin Laden", "Michel Nogueira", "Nizam", "Raquele Cardozo",
                "Rodriguinho", "Thalyta Alves", "Vanessa Lopes", "Vinicius Rodrigues", "Wanessa Camargo",
                "Yasmin Brunet"};
        for (String nome : nomes) {
            participantes.add(new Jogador(nome));
        }
        return participantes;
    }

    private static void registrarVoto(ArrayList<Jogador> participantes, String voto) {
        boolean encontrado = false;
        for (Jogador jogador : participantes) {
            if (jogador.getNome().equalsIgnoreCase(voto)) {
                jogador.incrementaUmVoto();
                JOptionPane.showMessageDialog(null, "Voto registrado para " + jogador.getNome());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "O participante '" + voto + "' não foi encontrado.");
        }
    }

    private static Jogador encontrarEliminado(ArrayList<Jogador> participantes) {
        Jogador eliminado = null;
        int maxVotos = 0;
        for (Jogador jogador : participantes) {
            if (jogador.getVotos() > maxVotos) {
                maxVotos = jogador.getVotos();
                eliminado = jogador;
            }
        }
        return eliminado;
    }
}
