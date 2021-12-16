<template>
  <div class="form">
    <form @submit.prevent="submitForm" method="post" class="q-form">
      <label>
        <h2>Feast Finder Form</h2>
        <label for="zipcode" class="zipcode">Zipcode</label>
        <input
          type="text"
          id="zipcode"
          class="form-control"
          placeholder="zipcode"
          required
          autofocus
          v:model="form.zipCode"
          maxlength="5"
          minlength="5"
          v-model="form.zipCode"
        />
      </label>

      <label for="radius" class="radius">Radius</label>
      <select name="radius" id="radius" v-model="form.radius">
        <option value="5">5</option>
        <option value="10">10</option>
        <option value="15">15</option>
        <option value="20">20</option>
        <option value="25">25</option>
      </select>

      <h2>Feasting Zone</h2>

      <label class="checkbox-form" for="options.type"></label>
      <div class="row">
        <div id='word-checkbox'
          class="options col-sm-15"
          v-for="options in options"
          v-bind:key="options.id"
        >
          <label>
            {{ options.type }}
          </label>
          <input class='input'
            :id="options.type"
            v-model="form.cuisineType"
            type="checkbox"
            :value="options.type"
          />
        </div>
      </div>
    </form>
    {{ options.type }}

    <button type="submit" id="submit" v-on:click="submitForm">Submit</button>
    <button type="button" id="sendToDB" v-on:click="sendToServer">Save as Default Profile</button>
  </div>
</template>

<script>

import YelpService from "@/services/YelpService";
import UserService from '../services/UserService';

export default {
  name: "feastForm",
  data() {
    return {
      // need toupdate hte list
      options: [
        {
          type: "Thai",
        },
        {
          type: "Deli",
        },
        {
          type: "Pizza",
        },
        {
          type: "Chinese",
        },
        {
          type: "Healthy",
        },
        {
          type: "BBQ",
        },
        {
          type: "Seafood",
        },
        {
          type: "Italian",
        },
        {
          type: "Ethiopian",
        },
        {
          type: "Sushi",
        },
        {
          type: "Japanese",
        },
        {
          type: "Poke",
        },
        {
          type: "Burger",
        },
        {
          type: "Hotdogs",
        },
        {
          type: "Fried Chicken",
        },
        {
          type: "American",
        },
        {
          type: "Café",
        },
        {
          type: "Coffee",
        },
        {
          type: "Tea",
        },
        {
          type: "Fast Food",
        },
        {
          type: "Burrito",
        },
        {
          type: "Boba Tea",
        },
        {
          type: "Vietanamese",
        },
        {
          type: "Argentinian",
        },
        {
          type: "Steak House",
        },
        {
          type: "Milkshake",
        },
        {
          type: "Bakery",
        },
        {
          type: "Bar",
        },
        {
          type: "Brewery",
        },
        {
          type: "Wine",
        },
          {
          type: "Middle Eastern",
        },
        {
          type: "Kosher",
        },
        {
          type: "Noodles",
        },
         {
          type: "Tacos",
        },
        {
          type: "Soul Food",
        },
        {
          type: "Gluten Free",
        },
        {
          type: "Vegan",
        },
        {
          type: "Vegetarian",
        },
        {
          type: "Indian",
        },
        {
          type: "Halal",
        },
        {
          type: "Korean",
        },
        {
          type: "Buffet",
        },
      ],

      form: {
        zipCode: "",
        radius: "",
        cuisineType: [],
      },
    };
  },

  methods: {
    submitForm() {
      const size = this.form.cuisineType.length;
      for (let i = 0; i < size; i++) {
        let stringCuisine = this.form.cuisineType[i];
        YelpService.getSearchResults(
          stringCuisine,
          this.form.zipCode,
          this.computedRadius
        ).then((response) => {
          this.$store.commit("SET_LIST", response.data);
        });
      }
    },
    sendToServer() {
      const newForm = {
        radius: this.form.radius,
        zipCode: this.form.zipCode,
        cuisineType: this.form.cuisineType
      }
      UserService.addForm(newForm)
    }
  },
  computed: {
    computedCuisineString() {
      return this.form.cuisineType[0];
    },
    computedRadius() {
      return this.form.radius * 1609;
    },
  },
};
</script>

<style>
* {
  font-family: sa;
}

#logo {
  display: block;
  margin-left: auto;
  margin-right: auto;
  margin-bottom: 50px;
  width: 25%;
}

.options {
  display: flex;
  justify-content: space-between;
}

h1 {
  text-align: center;
}

.form {
  display: block;
  width: 100%;
  max-width: 50rem;
  text-align: center;
  margin-left: auto;
  margin-right: auto;
  margin-bottom: 50px;
}

.q-form {
  display: block;
  margin-left: auto;
  margin-right: auto;
  margin-bottom: 50px;
  width: 100%;
  background-color: white;
  /* border: 2px solid black;
    border-radius: 5px; */
}

button {
  border: 1;
  border-radius: 20px;
  background: #0d6efd;

  font-family: serif;
  font-size: 100%;
  line-height: 1.2;
  white-space: nowrap;
  text-decoration: none;
  padding: 1rem 2rem;
  margin: 0.25rem;
  cursor: pointer;
}
.form-check-label {
  display: flex;
  font-family: serif;
  font-size: 100%;
  width: 100%;
}

.zipcode {
  border-radius: 20px;
  display: block;
  padding: 10px;
}
#zipcode {
  border-radius: 10px;
  width: 200px;
  height: 30px;
}

.radius {
  display: block;
  padding: 10px;
  size: 100%;
}
#radius {
  border-radius: 10px;
  width: 200px;
  height: 30px;
}

.row {
  box-shadow: 5px 5px 8px #888888;
  border-radius: 5px;
  padding: 5px;
}


/* #options.type {
  
} */


</style>