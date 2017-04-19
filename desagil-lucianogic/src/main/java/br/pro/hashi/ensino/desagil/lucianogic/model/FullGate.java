package br.pro.hashi.ensino.desagil.lucianogic.model;

public class FullGate extends Gate {
	private XorGate xorTop;
	private XorGate xorBottom;
	private AndGate andBottom;
	private AndGate andTop;
	private OrGate orMid;
	
	public FullGate(){
		super(3,2);
		
		name = "Full";
		
		xorTop = new XorGate();
		xorBottom = new XorGate();
		andTop = new AndGate();
		andBottom = new AndGate();
		orMid = new OrGate();

		orMid.connect(andTop, 0);
		orMid.connect(andBottom, 1);
		andTop.connect(xorTop, 1);
		xorBottom.connect(xorTop, 1);

	}
	@Override
	public boolean doRead(int index) {
		return orMid.read();		
	}
	@Override
	protected void doConnect(Emitter emitter, int index) {
		switch(index) {
		case 0:
			xorTop.connect(emitter, 1);
			andBottom.connect(emitter, 1);
			break;
		case 1:
			xorTop.connect(emitter, 0);
			andBottom.connect(emitter, 0);
			break;
		case 2:
			xorBottom.connect(emitter, 0);
			andTop.connect(emitter, 0);
			break;
		}
	}
}