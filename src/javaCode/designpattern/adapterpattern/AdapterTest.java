package javaCode.designpattern.adapterpattern;


// 国标插头
interface CnPluginInterface {
    void chargeWith2Pins();
}

// 实现国标插座的充电方法
class CnPlugin implements CnPluginInterface {
    public void chargeWith2Pins() {
        System.out.println("charge with CnPlugin");
    }
}

// 在国内家中充电
class Home {
    private CnPluginInterface cnPlugin;

    public Home() { }

    public Home(CnPluginInterface cnPlugin) {
        this.cnPlugin = cnPlugin;
    }

    public void setPlugin(CnPluginInterface cnPlugin) {
        this.cnPlugin = cnPlugin;
    }

    // 充电
    public void charge() {
        // 国标充电
        cnPlugin.chargeWith2Pins();
    }
}
// 英标插头
interface EnPluginInterface {
    void chargeWith3Pins();
}

// 实现英标插座的充电方法
class EnPlugin implements EnPluginInterface {
    public void chargeWith3Pins() {
        System.out.println("charge with EnPlugin");
    }
}

//适配器
class PluginAdapter implements CnPluginInterface {
    private EnPluginInterface enPlugin;

    public PluginAdapter(EnPluginInterface enPlugin) {
        this.enPlugin = enPlugin;
    }

    // 这是重点，适配器实现了英标的插头，然后重载国标的充电方法为英标的方法
    @Override
    public void chargeWith2Pins() {
        enPlugin.chargeWith3Pins();
    }
}

// 适配器测试类
public class AdapterTest {
    public static void main(String[] args) {
        EnPluginInterface enPlugin = new EnPlugin();
        Home home = new Home();
        PluginAdapter pluginAdapter = new PluginAdapter(enPlugin);
        home.setPlugin(pluginAdapter);
        // 会输出 “charge with EnPlugin”
        home.charge();

        CnPluginInterface cnPlugin = new CnPlugin();
        home = new Home(cnPlugin);
        // 会输出 “charge with CnPlugin”
        home.charge();
    }
}
