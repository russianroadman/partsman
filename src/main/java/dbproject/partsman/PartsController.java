package dbproject.partsman;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class PartsController {

    @GetMapping("/")
    public String indexRequest(){
        return "index";
    }

    @GetMapping("instock")
    public String instockRequest(Model model){
        List<String[]> instock = StoredProcedures.getInstock();
        model.addAttribute("instock", instock);
        return "instock";
    }

    @GetMapping("brands")
    public String brandsRequest(Model model){
        List<String> brands = StoredProcedures.getBrands();
        model.addAttribute("brands", brands);
        return "brands";
    }

    @GetMapping("customers")
    public String customersRequest(Model model){
        List<String[]> customers = StoredProcedures.getCustomers();
        model.addAttribute("customers", customers);
        return "customers";
    }

    @GetMapping("items")
    public String itemsRequest(Model model){
        List<String[]> items = StoredProcedures.getItems();
        model.addAttribute("items", items);
        return "items";
    }

    @PostMapping("items/add")
    public String itemsAddRequest(Model model,
                                    @RequestParam String title,
                                    @RequestParam String snum,
                                    @RequestParam String qtty,
                                    @RequestParam String price){
        StoredProcedures.addItem(title, snum, qtty, price);
        List<String[]> items = StoredProcedures.getItems();
        model.addAttribute("items", items);
        return "items";
    }

    @GetMapping("orders")
    public String ordersRequest(Model model){
        List<String[]> orders = StoredProcedures.getOrders();
        model.addAttribute("orders", orders);
        return "orders";
    }

    @GetMapping("suppliers")
    public String suppliersRequest(Model model){
        List<String[]> suppliers = StoredProcedures.getSuppliers();
        model.addAttribute("suppliers", suppliers);
        return "suppliers";
    }

    @GetMapping("workers")
    public String workersRequest(Model model){
        List<String[]> workers = StoredProcedures.getWorkers();
        model.addAttribute("workers", workers);
        return "workers";
    }
}
