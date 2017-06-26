package model;

public class Mensagem extends AbstractModel{
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
	public void setId(Integer id) {
		
	}
	
	

}
