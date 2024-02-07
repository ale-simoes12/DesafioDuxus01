
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service que possuirá as regras de negócio para o processamento dos dados
 * solicitados no desafio!
 *
 * @author carlosau
 */
public class ApiService {

    private List<Integrante> i;
    //DadosParaTesteApiService da;

    /**
     * Vai retornar uma lista com os nomes dos integrantes do time daquela data
     */
    public Time timeDaData(LocalDate data, List<Time> todosOsTimes, List<Integrante> integrantes, List<ComposicaoTime> c) {

        List<Integer> listaIdTime = new ArrayList<>();

        for (Time ti : todosOsTimes) {
            //salvando o id do time dessa data
            if (ti.getData().equals(data)) {
                listaIdTime.add(ti.getId());

            }
        }

        //recuperar id dos integrantes registrados nessa data
        List<Integer> listaIdInte = new ArrayList<>();
        for (ComposicaoTime comp : c) {
            for (Integer i : listaIdTime) {
                if (comp.getId_time() == i.intValue()) {
                    listaIdInte.add(comp.getId_integrante());
                }
            }

        }
        System.out.println(data);
        ///recuperar nomes do integrantes pelo id
        for (Integrante inte : integrantes) {
            for (Integer j : listaIdInte) {
                if (inte.getId() == j.intValue()) {
                    //printa o nome do intrante
                    System.out.println(inte.getNome());
                }

            }

        }
        return null;
    }

    /**
     * Vai retornar o integrante que tiver presente na maior quantidade de times
     * dentro do período
     */
    public Integrante integranteMaisUsado(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes, List<Integrante> integrantes, List<ComposicaoTime> c) {
        // TODO Implementar método seguindo as instruções!
        
         int anoIni = dataInicial.getYear();

        int anoFinal = dataFinal.getYear();

        List<Integer> listaIdTime = new ArrayList<>();
        for (Time ti : todosOsTimes) {
            //salvando o id do time dessa data
            if (ti.getData().getYear() >= anoIni && ti.getData().getYear() >= anoFinal) {
                listaIdTime.add(ti.getId());

            }
        }
        //recuperar id dos integrantes registrados nessa data
        List<String> listaIdInte = new ArrayList<>();
        for (ComposicaoTime comp : c) {
            for (Integer i : listaIdTime) {
                if (comp.getId_time() == i.intValue()) {
                    listaIdInte.add(String.valueOf(comp.getId_integrante()));
                }
            }

        }

        Map<String, Integer> contagemTermos = new HashMap<>();

        // Percorrer a lista e contar a frequência de cada termo
        for (String termo : listaIdInte) {
            contagemTermos.put(termo, contagemTermos.getOrDefault(termo, 0) + 1);
        }

        // Encontrar o termo mais frequente
        String termoMaisFrequente = null;
        int frequenciaMaxima = 0;

        for (Map.Entry<String, Integer> entry : contagemTermos.entrySet()) {
            String termo = entry.getKey();
            int frequencia = entry.getValue();

            if (frequencia > frequenciaMaxima) {
                termoMaisFrequente = termo;
                frequenciaMaxima = frequencia;
            }
        }

        int id_maisfrequente = Integer.parseInt(termoMaisFrequente);

        System.out.println("DATA ENTRE" + anoIni);
        System.out.print(" e ");
        System.out.println(anoFinal);
        ///recuperar nomes do integrantes pelo id
        System.out.println("Integrantes: ");
        for (Integrante inte : integrantes) {

            if (inte.getId() == id_maisfrequente) {
                //printa o nome do intrante mais frequente
                System.out.println(inte.getNome());
            }

        }
        return null;
    }

    /**
     * Vai retornar uma lista com os nomes dos integrantes do time mais comum
     * dentro do período
     */
    public List<String> timeMaisComum(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes, List<Integrante> integrantes, List<ComposicaoTime> c) {
        // TODO Implementar método seguindo as instruções!

       

        return null;
    }

    /**
     * Vai retornar a função mais comum nos times dentro do período
     */
    public String funcaoMaisComum(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
        // TODO Implementar método seguindo as instruções!
        return null;
    }

    /**
     * Vai retornar o nome da Franquia mais comum nos times dentro do período
     */
    public String franquiaMaisFamosa(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
        // TODO Implementar método seguindo as instruções!
        return null;
    }

    /**
     * Vai retornar o nome da Franquia mais comum nos times dentro do período
     */
    public Map<String, Long> contagemPorFranquia(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
        // TODO Implementar método seguindo as instruções!
        return null;
    }

    /**
     * Vai retornar o número (quantidade) de Funções dentro do período
     */
    public Map<String, Long> contagemPorFuncao(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
        // TODO Implementar método seguindo as instruções!
        return null;
    }

}
