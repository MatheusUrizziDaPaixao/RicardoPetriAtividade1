public class Main {
    public static void main(String[] args) {
        ListaSimples listaSimples = new ListaSimples(5);

        System.out.println("Quantidade inicial: " + listaSimples.contar());

        listaSimples.adicionarElemento("Arroz");
        listaSimples.adicionarElemento("Feijão");
        listaSimples.adicionarElemento("Sabão em Pó");
        listaSimples.adicionarElemento("Papel Higiênico");
        listaSimples.adicionarElemento("Óleo");
        listaSimples.buscarElemento("Óleo");
        listaSimples.removerElemento("Óleo");
        listaSimples.buscarElemento("Óleo");
        listaSimples.exibirElementos();

        System.out.println("Quantidade após adicionar: " + listaSimples.contar());

        listaSimples.removerElemento("Feijão");
        System.out.println("Quantidade após remover: " + listaSimples.contar());

        System.out.println("Ultimo indice de 'Arroz': " + listaSimples.ultimoIndiceDe("Arroz"));
        System.out.println("Substituicoes de 'Arroz' por 'Trigo': " + listaSimples.substituir("Arroz", "Trigo"));
        System.out.println("Remover por indice 1: " + listaSimples.removerPorIndice(1));
        listaSimples.exibirElementos();

        System.out.println("Adicionar vários (Maçã, Pera): " + listaSimples.adicionarVarios(new String[]{"Maçã", "Pera"}));
        System.out.println("Obter elemento no índice 2: " + listaSimples.obter(2));
        System.out.println("Inserir 'Uva' no índice 1: " + listaSimples.inserir(1, "Uva"));
        listaSimples.exibirElementos();

        System.out.println("Quantidade de elementos (contar): " + listaSimples.contar());
        System.out.println("Remover todas as ocorrencias de 'Arroz': " + listaSimples.removerTodas("Arroz"));
        listaSimples.limpar();
        System.out.println("Quantidade após limpar: " + listaSimples.contar());
        listaSimples.exibirElementos();
        System.out.println("Teste de estresse (índice negativo): " + listaSimples.obter(-5));
        System.out.println("Teste de estresse (índice gigante): " + listaSimples.removerPorIndice(999));
    }
}
