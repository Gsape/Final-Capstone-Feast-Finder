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

      <label class="checkbox-form" for="options.type">
        <div class="options" v-for="options in options" v-bind:key="options.id">
          <label class="form-check-label">
            {{ options.type }}
          </label>
          <input
            :id="options.type"
            v-model="form.cuisineType"
            type="checkbox"
            :value="options.type"
          />
        </div>
      </label>
    </form>
    {{ options.type }}

    <button type="submit" id="submit" v-on:click="submitForm">Submit</button>
  </div>
</template>

<script>
import userService from "@/services/UserService";

export default {
  data() {
    return {
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
      userService.addForm(this.form).then((response) => {
        if (response.status == 201) {
          this.$store.commit("SET_USER", response.data.form);
          this.$router.push("/");
        } else {
          this.$router.push("/login")
        }
      });
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

h1 {
  text-align: center;
}

.form {
  display: block;
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
  width: 50%;
  /* border: 2px solid black;
    border-radius: 5px; */
}

button {
  border: 1;
  border-radius: 20px;
  background: green;
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
  margin-left: 400px;
  font-family: serif;
  font-size: 100%;
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
</style>