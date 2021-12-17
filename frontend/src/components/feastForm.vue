<template>
  <div class="form" >
    <form @submit.prevent="submitForm" method="post" class="q-form">
      <h2 class="formTop">Feast Finder Form</h2>
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

      <label for="radius" class="radius">Radius</label>
      <select name="radius" id="radius" v-model="form.radius">
        <option value="5">5 Miles</option>
        <option value="10">10 Miles</option>
        <option value="15">15 Miles</option>
        <option value="20">20 Miles</option>
        <!-- <option value="25">25</option> -->
      </select>

      <h2 id="zone">Feasting Zone</h2>

      <container id="setCheckScroll">
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
      </container>
    
    <!-- {{ options.type }} -->
    </form>
    <button class="doWhatIWant" type="submit" id="submit" v-on:click="submitForm">Submit</button>
    <!-- <button type="button" id="sendToDB" v-on:click="sendToServer">Save as Default Profile</button> -->
  
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
      console.log(size);
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
@import url('https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&display=swap');
* {
    font-family: 'Open Sans', sans-serif;
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
  font-size: 55px;
}

.form {
  display: block;
  width: 100%;
  max-width: 50rem;
  text-align: center;
  margin-left: auto;
  margin-right: auto;
}

.q-form {
  display: flex;
  flex-direction: column;
  margin-left: auto;
  margin-right: auto;
  width: 100%;
  background-color: rgba(255,255,255,0.5);
}

.doWhatIWant {
  border-radius: 10px;
  background-color: #6046ED;
  box-shadow: 0px 4px 8px 0px #F887D6;
  padding: 10px;
  margin-top: 15px;
  cursor: pointer;
  width: 100%;
  color: white;
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

#zone {
  margin-top: 25px;
}

.setCheckScroll {
  height: 200px;
  overflow:hidden; 
  overflow-y:scroll;
}

</style>