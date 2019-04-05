package application.model.viewmodel.admin;

import application.model.viewmodel.common.ChartVM;
import application.model.viewmodel.common.LayoutHeaderAdminVM;

public class AdminChartVM {

    private LayoutHeaderAdminVM layoutHeaderAdminVM;
    private ChartVM countProductByCategory;
    private  ChartVM countProductSold;


    public ChartVM getCountProductSold() {
        return countProductSold;
    }

    public void setCountProductSold(ChartVM countProductSold) {
        this.countProductSold = countProductSold;
    }

    public LayoutHeaderAdminVM getLayoutHeaderAdminVM() {
        return layoutHeaderAdminVM;
    }

    public void setLayoutHeaderAdminVM(LayoutHeaderAdminVM layoutHeaderAdminVM) {
        this.layoutHeaderAdminVM = layoutHeaderAdminVM;
    }

    public ChartVM getCountProductByCategory() {
        return countProductByCategory;
    }

    public void setCountProductByCategory(ChartVM countProductByCategory) {
        this.countProductByCategory = countProductByCategory;
    }

    public AdminChartVM(LayoutHeaderAdminVM layoutHeaderAdminVM, ChartVM countProductByCategory) {
        this.layoutHeaderAdminVM = layoutHeaderAdminVM;
        this.countProductByCategory = countProductByCategory;
    }

    public AdminChartVM() {
    }
}
