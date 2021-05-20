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

    /* ************************************************************* */
    /* ************************** INSTOCK ************************** */
    /* ************************************************************* */

    @GetMapping("instock")
    public String instockRequest(Model model){
        List<String[]> instock = StoredProcedures.getInstock();
        model.addAttribute("instock", instock);
        return "instock";
    }

    /* ************************************************************* */
    /* *************************** BRANDS ************************** */
    /* ************************************************************* */

    @GetMapping("brands")
    public String brandsRequest(Model model){
        List<String> brands = BrandsCRUD.read();
        model.addAttribute("brands", brands);
        return "brands";
    }

    @PostMapping("brands")
    public String brandsAddRequest(Model model, @RequestParam String title){
        BrandsCRUD.create(title);
        List<String> brands = BrandsCRUD.read();
        model.addAttribute("brands", brands);
        return "redirect:/brands";
    }

    @PostMapping("/brands/delete")
    public String brandsRemoveRequest(Model model, @RequestParam String id){
        BrandsCRUD.delete(id);
        List<String> brands = BrandsCRUD.read();
        model.addAttribute("brands", brands);
        return "redirect:/brands";
    }

    @PostMapping("/brands/update")
    public String brandsUpdateRequest(Model model, @RequestParam String id, @RequestParam String title){
        BrandsCRUD.update(id, title);
        List<String> brands = BrandsCRUD.read();
        model.addAttribute("brands", brands);
        return "redirect:/brands";
    }

    /* ************************************************************* */
    /* ************************* CUSTOMERS ************************* */
    /* ************************************************************* */

    @GetMapping("customers")
    public String customersRequest(Model model){
        List<String[]> customers = StoredProcedures.getCustomers();
        model.addAttribute("customers", customers);
        return "customers";
    }

    /* ************************************************************* */
    /* *************************** ITEMS *************************** */
    /* ************************************************************* */

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

    /* ************************************************************* */
    /* *************************** ORDERS ************************** */
    /* ************************************************************* */

    @GetMapping("orders")
    public String ordersRequest(Model model){
        List<String[]> orders = StoredProcedures.getOrders();
        model.addAttribute("orders", orders);
        return "orders";
    }

    /* ************************************************************* */
    /* ************************* SUPPLIERS ************************* */
    /* ************************************************************* */

    @GetMapping("suppliers")
    public String suppliersRequest(Model model){
        List<String[]> suppliers = SuppliersCRUD.read();
        model.addAttribute("suppliers", suppliers);
        return "suppliers";
    }

    @PostMapping("suppliers")
    public String suppliersAddRequest(Model model,
                                      @RequestParam String country,
                                      @RequestParam String homestate,
                                      @RequestParam String city,
                                      @RequestParam String street,
                                      @RequestParam String building,
                                      @RequestParam String zip){
        SuppliersCRUD.create(country, homestate, city, street, building, zip);
        List<String[]> suppliers = SuppliersCRUD.read();
        model.addAttribute("suppliers", suppliers);
        return "redirect:/suppliers";
    }

    @PostMapping("/suppliers/delete")
    public String suppliersRemoveRequest(Model model,
                                         @RequestParam String id){
        SuppliersCRUD.delete(id);
        List<String[]> suppliers = SuppliersCRUD.read();
        model.addAttribute("suppliers", suppliers);
        return "redirect:/suppliers";
    }

    @PostMapping("/suppliers/update")
    public String suppliersUpdateRequest(Model model,
                                         @RequestParam String id,
                                         @RequestParam String country,
                                         @RequestParam String homestate,
                                         @RequestParam String city,
                                         @RequestParam String street,
                                         @RequestParam String building,
                                         @RequestParam String zip){
        SuppliersCRUD.update(id, country, homestate, city, street, building, zip);
        List<String[]> suppliers = SuppliersCRUD.read();
        model.addAttribute("suppliers", suppliers);
        return "redirect:/suppliers";
    }

    /* ************************************************************* */
    /* ************************** WORKERS ************************** */
    /* ************************************************************* */

    @GetMapping("workers")
    public String workersRequest(Model model){
        List<String[]> workers = WorkersCRUD.read();
        model.addAttribute("workers", workers);
        return "workers";
    }

    @PostMapping("workers")
    public String workersAddRequest(Model model,
                                      @RequestParam String firstname,
                                      @RequestParam String secondname,
                                      @RequestParam String middlename){
        WorkersCRUD.create(firstname, secondname, middlename);
        List<String[]> workers = WorkersCRUD.read();
        model.addAttribute("workers", workers);
        return "redirect:/workers";
    }

    @PostMapping("/workers/delete")
    public String workersRemoveRequest(Model model,
                                         @RequestParam String id){
        WorkersCRUD.delete(id);
        List<String[]> workers = WorkersCRUD.read();
        model.addAttribute("workers", workers);
        return "redirect:/workers";
    }

    @PostMapping("/workers/update")
    public String workersUpdateRequest(Model model,
                                         @RequestParam String id,
                                         @RequestParam String firstname,
                                         @RequestParam String secondname,
                                         @RequestParam String middlename){
        WorkersCRUD.update(id, firstname, secondname, middlename);
        List<String[]> workers = WorkersCRUD.read();
        model.addAttribute("workers", workers);
        return "redirect:/workers";
    }

}
