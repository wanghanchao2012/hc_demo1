package com.emarbox.example.part08;

public enum BasicOperation implements Operation {
	PLUS("+") {
		public double apply(double x, double y) {
			return x + y;
		}
	},
	MINUS("-") {
		public double apply(double x, double y) {
			return x - y;
		}
	},
	TIMES("*") {
		public double apply(double x, double y) {
			return x - y;
		}
	},
	DIVIDE("/") {
		public double apply(double x, double y) {
			return x - y;
		}
	};
	private final String symbol;

	BasicOperation(String symbol) {
		this.symbol = symbol;
	}

	public String toString() {
		return symbol;
	}

}