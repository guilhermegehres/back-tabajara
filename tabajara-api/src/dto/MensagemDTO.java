package dto;

import model.Mensagem;

public class MensagemDTO extends AbstractDTO<Mensagem>{

	private Boolean success;
	
	private String msg;
	
	private String err;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getErr() {
		return err;
	}

	public void setErr(String err) {
		this.err = err;
	}
	
	@Override
	public void setValues(Mensagem t) {
		// TODO Auto-generated method stub
	}


}
