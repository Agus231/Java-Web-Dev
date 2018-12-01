package edu.epam.xml.model.entity;

import java.util.Date;

public abstract class Candy {
    protected String candyId;
    protected String name;
    protected Enum type;
    protected int energy;
    protected String production;
    protected Date producedDate;

    protected Values values;

    protected Ingredients ingredients;

    public Candy(){
        values = new Values();
        ingredients = new Ingredients();
    }

    public String getCandyId() {
        return candyId;
    }

    public void setCandyId(String candyId) {
        this.candyId = candyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public Date getProducedDate() {
        return producedDate;
    }

    public void setProducedDate(Date producedDate) {
        this.producedDate = producedDate;
    }

    public Values getValues() {
        return values;
    }

    public void setValues(Values values) {
        this.values = values;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    public Enum getType() {
        return type;
    }

    public void setType(Enum type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Candy candy = (Candy) o;

        if (energy != candy.energy) return false;
        if (candyId != null ? !candyId.equals(candy.candyId) : candy.candyId != null) return false;
        if (name != null ? !name.equals(candy.name) : candy.name != null) return false;
        if (type != null ? !type.equals(candy.type) : candy.type != null) return false;
        if (production != null ? !production.equals(candy.production) : candy.production != null) return false;
        if (producedDate != null ? !producedDate.equals(candy.producedDate) : candy.producedDate != null) return false;
        if (values != null ? !values.equals(candy.values) : candy.values != null) return false;
        return ingredients != null ? ingredients.equals(candy.ingredients) : candy.ingredients == null;
    }

    @Override
    public int hashCode() {
        int result = candyId != null ? candyId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + energy;
        result = 31 * result + (production != null ? production.hashCode() : 0);
        result = 31 * result + (producedDate != null ? producedDate.hashCode() : 0);
        result = 31 * result + (values != null ? values.hashCode() : 0);
        result = 31 * result + (ingredients != null ? ingredients.hashCode() : 0);
        return result;
    }
}
