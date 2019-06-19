// Index.vue

<template>
    <div>
        <h1>Liste des écoles</h1>
        <p><router-link :to="{name: 'CreateEcole'}" class="btn btn-primary">Create</router-link></p>
        <table class="table table-hover">
            <thead>
            <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Actions</td>
            </tr>
            </thead>

            <tbody>
                <tr v-for="item in items" :key="item.idEcole">
                    <td>{{ item.idEcole }}</td>
                    <td>{{ item.nomEcole }}</td>
                    <td><router-link :to="{name: 'EditEcole', params: { id: item.idEcole }}" class="btn btn-primary">Edit</router-link></td>
                    <td><button class="btn btn-danger"  v-on:click="deleteItem(item.idEcole)">Delete</button></td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>

    export default {
        data(){
            return{
                items: [],
                myJson: ''
            }
        },

        created: function()
        {
            this.fetchItems();
            this.getJson();
        },

        methods: {
            fetchItems()
            {
              let uri = 'http://localhost:8080/api/ecoles/getAll';
              this.axios.get(uri).then((response) => {
                  this.items = response.data;
              });
            },
            deleteItem(id)
            {
              let uri = 'http://localhost:8080/api/ecoles/delete/'+id;              
              this.axios.post(uri);
              this.$router.go();
            },
            getJson()
            {
              let uri = 'http://localhost:8080/api/ecoles/get/1';
              this.axios.get(uri).then((response) => {
                  this.myJson = response.data.nomEcole;
              });
            },
        }
    }
</script>