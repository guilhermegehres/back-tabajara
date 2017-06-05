import dto.ApartamentoDTO;
import service.ApartamentoService;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApartamentoService ap = new ApartamentoService();
		ApartamentoDTO dto = ap.getApartamento();
		System.out.println(dto);

	}

}
