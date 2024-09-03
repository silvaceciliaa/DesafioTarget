import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.util.ArrayList;
import java.util.List;


public class QuestaoTres {

    public static void main(String[] args) {

        try {

            File inputFile = new File("Faturamento.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("dia");

            List<Double> valores = new ArrayList<>();

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                double valor = Double.parseDouble(element.getElementsByTagName("valor").item(0).getTextContent());
                if (valor > 0.0) {
                    valores.add(valor);
                }
            }

            if (valores.isEmpty()) {
                System.out.println("Não há dados de faturamento para processar.");
                return;
            }

            double menorValor = valores.stream().min(Double::compareTo).orElse(0.0);
            double maiorValor = valores.stream().max(Double::compareTo).orElse(0.0);
            double soma = valores.stream().mapToDouble(Double::doubleValue).sum();
            double media = soma / valores.size();

            long diasAcimaDaMedia = valores.stream().filter(v -> v > media).count();

            System.out.println("Menor valor de faturamento ocorrido em um dia do mês: " + menorValor);
            System.out.println("Maior valor de faturamento ocorrido em um dia do mês: " + maiorValor);
            System.out.println(media);
            System.out.println("Número de dias no mês em que o valor de faturamento diário foi superior à média mensal: " + diasAcimaDaMedia);

        } catch (Exception e) {
            System.out.println("Erro ao processar o arquivo XML: " + e.getMessage());
        }
    }
}