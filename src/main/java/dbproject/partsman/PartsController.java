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
        model.addAttribute("instock", InstockCRUD.read());
        return "instock";
    }

    @PostMapping("/instock/update")
    public String instockUpdateRequest(Model model,
                                       @RequestParam String id,
                                       @RequestParam String qtty,
                                       @RequestParam String price){
        InstockCRUD.update(id, qtty, price);
        model.addAttribute("instock", InstockCRUD.read());
        return "redirect:/instock";
    }

    @PostMapping("/instock/delete")
    public String instockDeleteRequest(Model model, @RequestParam String id){
        InstockCRUD.delete(id);
        model.addAttribute("instock", InstockCRUD.read());
        return "redirect:/instock";
    }

    /* ************************************************************* */
    /* *************************** BRANDS ************************** */
    /* ************************************************************* */

    @GetMapping("brands")
    public String brandsRequest(Model model){
        List<String[]> brands = BrandsCRUD.read();
        model.addAttribute("brands", brands);
        return "brands";
    }

    @PostMapping("brands")
    public String brandsAddRequest(Model model, @RequestParam String title){
        BrandsCRUD.create(title);
        List<String[]> brands = BrandsCRUD.read();
        model.addAttribute("brands", brands);
        return "redirect:/brands";
    }

    @PostMapping("/brands/delete")
    public String brandsRemoveRequest(Model model, @RequestParam String id){
        BrandsCRUD.delete(id);
        List<String[]> brands = BrandsCRUD.read();
        model.addAttribute("brands", brands);
        return "redirect:/brands";
    }

    @PostMapping("/brands/update")
    public String brandsUpdateRequest(Model model, @RequestParam String id, @RequestParam String title){
        BrandsCRUD.update(id, title);
        List<String[]> brands = BrandsCRUD.read();
        model.addAttribute("brands", brands);
        return "redirect:/brands";
    }

    /* ************************************************************* */
    /* ************************* CUSTOMERS ************************* */
    /* ************************************************************* */

    @GetMapping("customers")
    public String customersRequest(Model model){
        List<String[]> customers = CustomersCRUD.read();
        model.addAttribute("customers", customers);
        return "customers";
    }

    @PostMapping("customers")
    public String customersAddRequest(Model model,
                                      @RequestParam String firstname,
                                      @RequestParam String secondname,
                                      @RequestParam String middlename,
                                      @RequestParam String email,
                                      @RequestParam String phone,
                                      @RequestParam String city,
                                      @RequestParam String street,
                                      @RequestParam String building){
        CustomersCRUD.create(firstname, secondname, middlename, email, phone, city, street, building);
        List<String[]> customers = CustomersCRUD.read();
        model.addAttribute("customers", customers);
        return "redirect:/customers";
    }

    @PostMapping("/customers/delete")
    public String customersRemoveRequest(Model model, @RequestParam String id){
        CustomersCRUD.delete(id);
        List<String[]> customers = CustomersCRUD.read();
        model.addAttribute("customers", customers);
        return "redirect:/customers";
    }

    @PostMapping("/customers/update")
    public String customersUpdateRequest(Model model,
                                        @RequestParam String id,
                                        @RequestParam String firstname,
                                        @RequestParam String secondname,
                                        @RequestParam String middlename,
                                        @RequestParam String email,
                                        @RequestParam String phone,
                                        @RequestParam String city,
                                        @RequestParam String street,
                                        @RequestParam String building){
        CustomersCRUD.update(id, firstname, secondname, middlename, email, phone, city, street, building);
        List<String[]> customers = CustomersCRUD.read();
        model.addAttribute("customers", customers);
        return "redirect:/customers";
    }

    /* ************************************************************* */
    /* *************************** ITEMS *************************** */
    /* ************************************************************* */

    @GetMapping("items")
    public String itemsRequest(Model model){
        model.addAttribute("items", ItemsCRUD.read());
        model.addAttribute("suppliers", SuppliersCRUD.read());
        model.addAttribute("brands", BrandsCRUD.read());
        return "items";
    }

    @PostMapping("items/add-instock")
    public String itemsAddToInstockRequest(Model model,
                                    @RequestParam String title,
                                    @RequestParam String snum,
                                    @RequestParam String qtty,
                                    @RequestParam String price){
        InstockCRUD.create(title, snum, qtty, price);
        model.addAttribute("items", ItemsCRUD.read());
        model.addAttribute("suppliers", SuppliersCRUD.read());
        model.addAttribute("brands", BrandsCRUD.read());
        return "redirect:/items";
    }

    @PostMapping("items")
    public String itemsAddRequest(Model model,
                                  @RequestParam String type,
                                  @RequestParam String serial,
                                  @RequestParam String supplierID,
                                  @RequestParam String brandTitle,
                                  @RequestParam String description,
                                  @RequestParam String title,
                                  @RequestParam String category,
                                  @RequestParam String partQtty){
        supplierID = supplierID.replaceAll("[^\\d.]", "");
        ItemsCRUD.create(type, serial, supplierID, brandTitle, description, title, category, partQtty);
        model.addAttribute("items", ItemsCRUD.read());
        model.addAttribute("suppliers", SuppliersCRUD.read());
        model.addAttribute("brands", BrandsCRUD.read());
        return "redirect:/items";
    }

    @PostMapping("items/update")
    public String itemsUpdateRequest(Model model,
                                  @RequestParam String selectedSerial,
                                  @RequestParam String selectedTitle,
                                  @RequestParam String serial,
                                  @RequestParam String supplierID,
                                  @RequestParam String brandTitle,
                                  @RequestParam String description,
                                  @RequestParam String title,
                                  @RequestParam String category,
                                  @RequestParam String partQtty){
        supplierID = supplierID.replaceAll("[^\\d.]", "");
        ItemsCRUD.update(selectedSerial, selectedTitle, serial, supplierID, brandTitle, description, title, category, partQtty);
        model.addAttribute("items", ItemsCRUD.read());
        model.addAttribute("suppliers", SuppliersCRUD.read());
        model.addAttribute("brands", BrandsCRUD.read());
        return "redirect:/items";
    }

    @PostMapping("items/delete")
    public String itemsDeleteRequest(Model model,
                                     @RequestParam String selectedSerial,
                                     @RequestParam String selectedTitle){
        ItemsCRUD.delete(selectedSerial, selectedTitle);
        model.addAttribute("items", ItemsCRUD.read());
        model.addAttribute("suppliers", SuppliersCRUD.read());
        model.addAttribute("brands", BrandsCRUD.read());
        return "redirect:/items";
    }

    /* ************************************************************* */
    /* *************************** ORDERS ************************** */
    /* ************************************************************* */

    @GetMapping("orders")
    public String ordersRequest(Model model){
        List<String[]> orders = OrdersCRUD.read();
        model.addAttribute("orders", orders);
        return "orders";
    }

    @PostMapping("/orders/check")
    public String ordersCheckRequest(Model model, @RequestParam String id, @RequestParam String state){
        OrdersCRUD.check(id, state);
        List<String[]> orders = OrdersCRUD.read();
        model.addAttribute("orders", orders);
        return "redirect:/orders";
    }

    @PostMapping("customers/add-order")
    public String ordersAddRequest(Model model, @RequestParam String customerId){
        OrdersCRUD.create(customerId);
        List<String[]> orders = OrdersCRUD.read();
        model.addAttribute("orders", orders);
        return "redirect:/customers";
    }

    @PostMapping("/orders/delete")
    public String ordersRemoveRequest(Model model, @RequestParam String id){
        OrdersCRUD.delete(id);
        List<String[]> orders = OrdersCRUD.read();
        model.addAttribute("orders", orders);
        return "redirect:/orders";
    }

    @PostMapping("/orders/update")
    public String ordersUpdateRequest(Model model,
                                         @RequestParam String id,
                                         @RequestParam String customerId,
                                         @RequestParam String workerId){
        OrdersCRUD.update(id, customerId, workerId);
        List<String[]> orders = OrdersCRUD.read();
        model.addAttribute("orders", orders);
        return "redirect:/orders";
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
