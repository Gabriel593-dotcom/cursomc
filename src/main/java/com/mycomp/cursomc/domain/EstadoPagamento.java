package com.mycomp.cursomc.domain;

public enum EstadoPagamento {

	PENDENTE(1, "Pendente"), QUITADO(2, "Quitado"), CANCELADO(3, "Cancelado");

	private int code;
	private String descricao;

	private EstadoPagamento(int code, String descricao) {
		this.code = code;
		this.descricao = descricao;
	}

	public int getCode() {
		return code;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EstadoPagamento toEnum(Integer code) {

		if (code == null) {
			return null;
		}

		for (EstadoPagamento ep : EstadoPagamento.values()) {
			if (ep.getCode() == code) {
				return ep;
			}
		}

		throw new IllegalArgumentException("Código EstadoPagamento inválido. " + code);
	}

}
