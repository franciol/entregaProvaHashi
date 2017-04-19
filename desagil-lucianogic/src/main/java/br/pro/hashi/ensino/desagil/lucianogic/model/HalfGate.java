package br.pro.hashi.ensino.desagil.lucianogic.model;

public class HalfGate extends Gate {
	private XorGate xorTop;
	private AndGate andBottom;
	
	public HalfGate(){
		super(2,1);
		
		name = "Half";
		
		xorTop = new XorGate();
		
		andBottom = new AndGate();
		


	}
	@Override
	public boolean doRead(int index) {
		return xorTop.read();
	}
	@Override
	protected void doConnect(Emitter emitter,int index) {
		switch(index) {
		case 0:
			xorTop.connect(emitter, 0);
			andBottom.connect(emitter, 0);
			break;
		case 1:
			xorTop.connect(emitter, 1);
			andBottom.connect(emitter, 1);
			break;
		
	}
	

}
}
