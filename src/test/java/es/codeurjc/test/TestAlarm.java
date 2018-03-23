package es.codeurjc.test;

import es.codeurj.test.Alarm;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import org.junit.Test;
import es.codeurjc.test.CombinableAlarmMatcher.*;
import es.codeurjc.test.MyMatchers;

public class TestAlarm {
	
	private Alarm alarm1, alarm2, alarm3;
	
	@Test
	public void Test01_ModuleAttribute() {
		// Given
		alarm1 = new Alarm("STORAGE-ENGINE", 3, "1.1.3.6.1.4.1.193.169.1.2.3.255", "Storage Engine: replication channels are down.", 4, "192.150.122.22");
		alarm2 = new Alarm(alarm1);
		alarm2.setErrorCode(2345);
		assertThat(alarm2, MyMatchers.isErrorCode(alarm1.getErrorCode()));
	
	}
	
	@Test
	public void Test02_ModuleAttribute() {
		// Given
		alarm1 = new Alarm("STORAGE-ENGINE", 3, "1.1.3.6.1.4.1.193.169.1.2.3.255", "Storage Engine: replication channels are down.", 4, "192.150.122.22");
		alarm2 = new Alarm(alarm1);
		alarm2.setModule("FALLO");
		assertThat(alarm2, MyMatchers.isModule(alarm1));
	
	}
	
	@Test
	public void Test03_AlarmWithAllOf_FallaPrimerAtributo() {
		// Given
		alarm1 = new Alarm("STORAGE-ENGINE", 3, "1.1.3.6.1.4.1.193.169.1.2.3.255", "Storage Engine: replication channels are down.", 4, "192.150.122.22");
		alarm2 = new Alarm(alarm1);
		alarm2.setModule("MODULE FALLO");
		assertThat(alarm2, allOf(MyMatchers.isModule(alarm1), MyMatchers.isActiveDescription(alarm1)));
	}
	
	@Test
	public void Test04_AlarmWithAllOf_FallaSegundoAtributo() {
		// Given
		alarm1 = new Alarm("STORAGE-ENGINE", 3, "1.1.3.6.1.4.1.193.169.1.2.3.255", "Storage Engine: replication channels are down.", 4, "192.150.122.22");
		alarm2 = new Alarm(alarm1);
		alarm2.setActiveDescription("HOLA CARACOLA");
		assertThat(alarm2, allOf(MyMatchers.isModule(alarm1), MyMatchers.isActiveDescription(alarm1)));
	}
	
	@Test
	public void Tes05_tAlarmWithAllOf_FallaTodosLosAtributos() {
		// Given
		alarm1 = new Alarm("STORAGE-ENGINE", 3, "1.1.3.6.1.4.1.193.169.1.2.3.255", "Storage Engine: replication channels are down.", 4, "192.150.122.22");
		alarm2 = new Alarm(alarm1);
		alarm2.setModule("MODULE FALLO");
		alarm2.setActiveDescription("MI ACTIVE DESCRIPTION");		
		assertThat(alarm2, allOf(MyMatchers.isModule(alarm1), MyMatchers.isActiveDescription(alarm1)));
	}
	
	@Test
	public void Test06_AlarmMatcher() {
		// Given
		alarm1 = new Alarm("STORAGE-ENGINE", 3, "1.1.3.6.1.4.1.193.169.1.2.3.255", "Storage Engine: replication channels are down.", 4, "192.150.122.22");
		alarm2 = new Alarm(alarm1);
		alarm2.setModule("MODULE FALLO");
		alarm2.setErrorCode(2323232);
		alarm2.setActiveDescription("HOLA CARACOLA");
		assertThat(alarm2, AlarmMatcher.alarmEqualTo(alarm1));		
	}
				
	@Test
	public void Test07_CombinableAlarmMatcher() {
		// Given
		alarm1 = new Alarm("STORAGE-ENGINE", 3, "1.1.3.6.1.4.1.193.169.1.2.3.255", "Storage Engine: replication channels are down.", 4, "192.150.122.22");
		alarm2 = new Alarm(alarm1);
		alarm2.setModule("FALLO");
		alarm2.setErrorCode(2323232);
		alarm2.setActiveDescription("HOLA CARACOLA");
		alarm3 = new Alarm(alarm1);
		alarm3.setSeverity(5666);
		assertThat(alarm2, CombinableAlarmMatcher.all(MyMatchers.isModule(alarm1)).and(MyMatchers.isActiveDescription(alarm1)));
	}
	
	@Test
	public void Test08_CombinableThreeAlarmMatcher() {
		// Given
		alarm1 = new Alarm("STORAGE-ENGINE", 3, "1.1.3.6.1.4.1.193.169.1.2.3.255", "Storage Engine: replication channels are down.", 4, "192.150.122.22");
		alarm3 = new Alarm(alarm1);
		alarm3.setErrorCode(25);
		alarm3.setModule("NUEVO MODULE");
		assertThat(alarm3, CombinableAlarmMatcher.all(MyMatchers.isModule(alarm1)).and(MyMatchers.isActiveDescription(alarm1)).
				and(MyMatchers.isErrorCode(alarm1.getErrorCode())));
	}
	
}
