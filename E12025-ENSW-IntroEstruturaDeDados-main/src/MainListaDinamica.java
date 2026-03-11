public class MainListaDinamica {
    public static void main(String[] args) {
        ListaDinamica listaDinamica = new ListaDinamica();
        listaDinamica.adicionarElemento("Arroz");
        listaDinamica.adicionarElemento("Feijão");
        listaDinamica.adicionarElemento("Batata");
        listaDinamica.adicionarElemento("Alho");
        listaDinamica.adicionarElemento("Cebola");
        listaDinamica.removerElemento("Alho");
        listaDinamica.exibir();

        System.out.println("Ultimo indice de 'Feijão': " + listaDinamica.ultimoIndiceDe("Feijão"));
        System.out.println("Substituições de 'Cebola' por 'Pimentão': " + listaDinamica.substituir("Cebola", "Pimentão"));
        System.out.println("Removido por indice 2: " + listaDinamica.removerPorIndice(2));
        listaDinamica.exibir();

        System.out.println("Adicionar vários (Manga, Melancia): " + listaDinamica.adicionarVarios(new String[]{"Manga", "Melancia"}));
        System.out.println("Obter elemento no índice 3: " + listaDinamica.obter(3));
        System.out.println("Inserir 'Banana' no índice 0: " + listaDinamica.inserir(0, "Banana"));
        listaDinamica.exibir();
        System.out.println("Total de nós na lista (contar): " + listaDinamica.contar());
        System.out.println("Remover todas as ocorrências de 'Feijão': " + listaDinamica.removerTodas("Feijão"));
        listaDinamica.limpar();
        System.out.println("Total após limpar: " + listaDinamica.contar());
        listaDinamica.exibir();
    }
}
