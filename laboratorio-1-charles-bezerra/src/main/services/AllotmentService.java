package main.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import main.dto.AllotmentDTO;
import main.dto.ProductDTO;
import main.interfaces.Repository;
import main.interfaces.ServiceRelation;
import main.models.Allotment;
import main.models.Product;

import com.google.gson.Gson;

public class AllotmentService implements ServiceRelation {
    private Repository<String, Allotment> repositoryAllotment;
    private Repository<String, Product> repositoryProduct;
    private Gson gson = new Gson();


    public AllotmentService(Repository<String, Allotment> repositoryAllotment,
            Repository<String, Product> repositoryProduct) {
        this.repositoryAllotment = repositoryAllotment;
        this.repositoryProduct = repositoryProduct;
    }

    public Collection<Allotment> getAll() {
        return repositoryAllotment.all();
    }

    public String create(String jsonData) {
        AllotmentDTO allotmentDTO = gson.fromJson(jsonData, AllotmentDTO.class);
        Product product = this.repositoryProduct.get(allotmentDTO.getIdProduct());

        repositoryAllotment.add(new Allotment(product, allotmentDTO.getAmount(), allotmentDTO.getExpiretionDate()));

        return product.getId();
    }

    public Collection<Allotment> searchForProductName(String name) {
        Collection<Allotment> result = new ArrayList<>();
        Iterator<Allotment> iterator = repositoryAllotment.all().iterator();

        Allotment allotment = null;

        while (iterator.hasNext()) {
            allotment = iterator.next();
            if (allotment.getProduct().getName().matches(name))
                result.add(allotment);
        }

        return result;
    }

    public Collection<Allotment> search(Product product) {
        if (product == null)
            throw new IllegalArgumentException("Argument product not can a null value");

        Collection<Allotment> result = new ArrayList<>();
        Iterator<Allotment> iterator = repositoryAllotment.all().iterator();
        Allotment aux;

        while (iterator.hasNext()) {
            aux = iterator.next();
            if (aux.getProduct().getId().equals(product.getId()))
                result.add(aux);
        }

        return result;
    }

    private Allotment search(Product product, Integer amount, String expiretionDate) {
        if (product == null)
            throw new IllegalArgumentException("Argument product not can a null value");

        Allotment result = null;
        Allotment aux;
        Iterator<Allotment> iterator = repositoryAllotment.all().iterator();

        while (iterator.hasNext()) {
            aux = iterator.next();
            if (aux.getProduct().getId().equals(product.getId()) && aux.getAmount().equals(amount)
                    && aux.getExpirationDate().equals(expiretionDate)) {
                result = aux;
                break;
            }
        }

        return result;
    }

    public void remove(String data) {
        AllotmentDTO aDTO = gson.fromJson(data, AllotmentDTO.class);
        Product product = repositoryProduct.get(aDTO.getIdProduct());

        if (product == null)
            throw new IllegalArgumentException("Argument product not can a null value");

        Allotment allotment = search(product, aDTO.getAmount(), aDTO.getExpiretionDate());

        if (allotment == null)
            throw new IllegalArgumentException("Allotment not found in repositoryAllotment");

        Allotment al = repositoryAllotment.remove(allotment.getId());

        if (al == null)
            throw new IllegalArgumentException("Allotment not found in repositories.AllotmentRepository");
    }

    public void remove(Object object) {
        if (object == null)
            throw new IllegalArgumentException("Argument object not can a null value");

        if (object.getClass() != Product.class)
            throw new IllegalArgumentException("Argument has been of type models.Product");

        Collection<Allotment> allotments = search((Product) object);

        allotments.stream().forEach(allotment -> {
            repositoryAllotment.remove(allotment.getId());
        });
    }
}
