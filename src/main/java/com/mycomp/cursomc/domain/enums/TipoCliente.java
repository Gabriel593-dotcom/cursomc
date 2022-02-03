package com.mycomp.cursomc.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa Fisica"), PESSOAJURIDICA(2, "Pessoa Juridica");

	private int code;
	private String descricao;

	private TipoCliente(int code, String descricao) {
		this.code = code;
		this.descricao = descricao;
	}

	public int getCode() {
		return code;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoCliente toEnum(Integer code) {
		if (code == null) {
			return null;
		}

		for (TipoCliente x : TipoCliente.values()) {

			if (code.equals(x.getCode())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("código inválido" + code);
	}

}
