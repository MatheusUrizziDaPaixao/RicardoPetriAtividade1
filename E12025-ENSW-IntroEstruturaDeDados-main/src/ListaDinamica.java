
public class ListaDinamica implements ListaOperacoes
{
    No inicio;

    public ListaDinamica() {
        this.inicio = new No(null);
        System.out.println("Lista dinâmica criada com sucesso!");
    }

    public void adicionarElemento(String elemento) {

        if(inicioEstaVazio()) {
            this.inicio.setConteudo(elemento);
        } else {
            No aux = this.inicio;
            No novoNo = new No(elemento);
            while(aux.getProx() != null) {
                aux = aux.getProx();
            }
            aux.setProx(novoNo);
        }
    }

    public void exibir() {
        if(inicioEstaVazio()) {
            System.out.println("Não existem elementos na lista dinâmica.");
        } else {
            No aux = this.inicio;
//            while(aux != null && aux.getConteudo() != null) {
//                System.out.println(aux.getConteudo());
//                aux = aux.getProx();
//            }

            while(aux != null) {
                System.out.println(aux.getConteudo());
                aux = aux.getProx();
            }
            //System.out.println(aux.getConteudo());
        }
    }

    private boolean inicioEstaVazio() {
        if(this.inicio.getConteudo() == null) {
            return true;
        } else {
            return false;
        }
    }

    public void removerElemento(String elemento) {
        if(inicioEstaVazio()) {
            System.out.println("Não há elementos a serem removidos.");
        } else {
            if(procurarElemento(elemento)) {
                //remover primeiro elemento isolado
                if(this.inicio.getProx() == null) {
                    System.out.println("Elemento + " + elemento + " removido!");
                    this.inicio.setConteudo(null);
                }
                //remover qualquer nó conectado
                else if(this.inicio.getProx() != null) {
                    No aux = this.inicio;
                    while(aux != null) {
                        if (this.inicio.getConteudo().equals(elemento)) {
                            System.out.println("Elemento " + elemento + " removido!");
                            this.inicio = this.inicio.getProx();
                            return;
                        } else if(aux.getProx().getConteudo().equals(elemento)) {
                            System.out.println("Elemento + " + elemento + " removido!");
                            aux.setProx(aux.getProx().getProx());
                            return;
                        }
                        aux = aux.getProx();
                    }
                }
            }
        }
    }

    public boolean procurarElemento(String elemento) {
        if(inicioEstaVazio()) {
            System.out.println("Não há elementos a serem procurados.");
        } else {
            No aux = this.inicio;
            while(aux != null) {
                if(aux.getConteudo().equals(elemento)) {
                    System.out.println("Elemento " + elemento + " encontrado!");
                    return true;
                }
                aux = aux.getProx();
            }
            System.out.println("Elemento " + elemento + " não existe na lista.");
        }
        return false;
    }

    @Override
    public int contar()
    {
        if(inicioEstaVazio())
        {
            return 0;
        }

        int quantidade = 0;
        No aux = this.inicio;

        while(aux != null && aux.getConteudo() != null)
        {
            quantidade++;
            aux = aux.getProx();
        }
        return quantidade;
    }
    @Override
    public String removerPorIndice(int indice) {
        if (indice < 0 || inicioEstaVazio()) return null;

        if (indice == 0) {
            String valor = this.inicio.getConteudo();
            if (this.inicio.getProx() == null) {
                this.inicio.setConteudo(null);
            } else {
                this.inicio = this.inicio.getProx();
            }
            return valor;
        }

        No aux = this.inicio;
        int pos = 0;
        while(aux != null && pos < indice - 1) {
            aux = aux.getProx();
            pos++;
        }

        if (aux == null || aux.getProx() == null) return null;

        String removido = aux.getProx().getConteudo();
        aux.setProx(aux.getProx().getProx());
        return removido;
    }

    @Override
    public int ultimoIndiceDe(String elemento)
    {
        if (elemento == null || inicioEstaVazio()) {
            return -1;
        }
        int idx = 0;
        int ultimo = -1;
        No aux = this.inicio;
        while (aux != null && aux.getConteudo() != null) {
            if (elemento.equals(aux.getConteudo())) {
                ultimo = idx;
            }
            aux = aux.getProx();
            idx++;
        }
        return ultimo;
    }

    @Override
    public int substituir(String antigo, String novo) {
        if (antigo == null || novo == null || inicioEstaVazio()) {
            System.out.println("Erro: Não é permitido substituir valores por nulo.");
            return 0;
        }
        int cont = 0;
        No aux = this.inicio;
        while (aux != null && aux.getConteudo() != null) {
            if (antigo.equals(aux.getConteudo())) {
                aux.setConteudo(novo);
                cont++;
            }
            aux = aux.getProx();
        }
        return cont;
    }
    @Override
    public int removerTodas(String elemento)
    {
        if (elemento == null || inicioEstaVazio()) {
            return 0;
        }
        int cont = 0;
        while (!inicioEstaVazio() && elemento.equals(this.inicio.getConteudo())) {
            removerPorIndice(0);
            cont++;
        }
        No aux = this.inicio;
        while (aux != null && aux.getProx() != null) {
            if (elemento.equals(aux.getProx().getConteudo())) {
                aux.setProx(aux.getProx().getProx());
                cont++;
            } else {
                aux = aux.getProx();
            }
        }
        return cont;
    }
    @Override
    public int adicionarVarios(String[] elementos) {
        int contador = 0;
        for (String elem : elementos) {
            this.adicionarElemento(elem);
            contador++;
        }
        return contador;
    }

    @Override
    public boolean inserir(int indice, String elemento) {
        if (indice < 0 || elemento == null) return false;

        if (indice == 0) {
            if (inicioEstaVazio()) {
                inicio.setConteudo(elemento);
            } else {
                No novoNo = new No(elemento);
                novoNo.setProx(inicio);
                inicio = novoNo;
            }
            return true;
        }

        No aux = inicio;
        for (int i = 0; i < indice - 1 && aux != null; i++) {
            aux = aux.getProx();
        }
        if (aux == null) return false;

        No novoNo = new No(elemento);
        novoNo.setProx(aux.getProx());
        aux.setProx(novoNo);
        return true;
    }

    @Override
    public String obter(int indice) {
        if (indice < 0 || inicioEstaVazio()) return null;
        No aux = inicio;
        int contador = 0;

        while (aux != null) {
            if (contador == indice) {
                return aux.getConteudo();
            }
            aux = aux.getProx();
            contador++;
        }

        return null;
    }
    @Override
    public void limpar()
    {
        this.inicio = new No(null);
    }

    @Override
    public int contarOcorrencias(String elemento)
    {
        if (elemento == null || inicioEstaVazio()) {
            return 0;
        }
        int cont = 0;
        No aux = this.inicio;
        while (aux != null && aux.getConteudo() != null) {
            if (elemento.equals(aux.getConteudo())) {
                cont++;
            }
            aux = aux.getProx();
        }
        return cont;
    }
}
