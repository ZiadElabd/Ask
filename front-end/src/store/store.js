import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export const store = new Vuex.Store({
    //strict: true,
    state: {
        userID:'',
        userName: '',
        userImage: "",
        questions: [],
        cur_question:{},
        users:[],
        followers:[],
        profileData:{},
        profileQuestions:[],
        homeQuestions:[],
        settings:{},
        notifications:[],
    },
    getters: {
        
    },
    mutations: {
        initialiseStore(state) {
            if (localStorage.getItem('userID') ) {
              state.userID = localStorage.getItem('userID');
              state.userName = localStorage.getItem('userName');
            }
        },
        saveUserData:(state , data) =>{
            localStorage.setItem('userID', data._id);
            localStorage.setItem('userName', data._name);
            state.userID = data._id;
            state.userName = data._name;
        },
        deleteUserData:(state) =>{
            localStorage.setItem('userID', '');
            localStorage.setItem('userName', '');
            state.userID = '';
            state.userName = '';
        },
        saveQuestions:(state , questions) =>{
            console.log("questions = " + questions);
            state.questions = questions;
        },
        saveAQuestion:(state , question) =>{
            console.log("cur_question = " + question);
            state.cur_question = question;
        },
        saveUsers:(state , users) =>{
            console.log("users = " + users);
            state.users = users;
        },
        saveFollowers:(state , followers) =>{
            console.log("followers = " + followers);
            let followersList = followers.map(e => {
                return e.userName;
            });
            state.followers = followersList;
        },
        saveProfileData:(state , profileData) =>{
            console.log("profileData = " + profileData);
            state.profileData = profileData;
        },
        saveProfileQuestions:(state , profileQuestions) =>{
            console.log("profileQuestions = " + profileQuestions);
            state.profileQuestions = profileQuestions;
        },
        saveHomeQuestions:(state , homeQuestions) =>{
            console.log("homeQuestions = " + homeQuestions);
            state.homeQuestions = homeQuestions;
        },
        saveSettings:(state , settings) =>{
            console.log("settings = " + settings);
            state.settings = settings;
        },
        saveNotifications:(state , notifications) =>{
            console.log("settings = " + notifications);
            state.notifications = notifications;
        },

    },
    actions: {
        getQuestions: async context => {
            //try {
                console.log('in store ' + store.state.userID);
                let response = [];
                response = await fetch( "http://localhost:5050/getQuestion/" + store.state.userID  + "/" + store.state.userName, {
                    method: "get", 
                    headers: { "Content-Type": "application/json" },
                }).then((res) => {
                    return res.json();
                }).then((data) => {
                    console.log(data);
                    return data;
                })
                console.log("bbbbbbbbb")
                console.log("questions response = " + response);
                context.commit('saveQuestions',response);
            /*} catch (error) {
                alert('error');
            }*/
        },
        getAQuestion: async (context,question_id) => {
            //try {
                console.log('question id in store =  ' + question_id);
                let response = [];
                response = await fetch( "http://localhost:5050/getAskAnsQuestion/" + store.state.userID  + "/" + question_id, {
                    method: "get", 
                    headers: { "Content-Type": "application/json" },
                }).then((res) => {
                    return res.json();
                }).then((data) => {
                    console.log(data);
                    return data;
                })
                console.log("bbbbbbbbb")
                console.log("questions response = " + response);
                context.commit('saveAQuestion',response);
            /*} catch (error) {
                alert('error');
            }*/
        },
        getNotifications: async context =>{
            //try {
                console.log('in store ' + store.state.userID);
                let response = [];
                response = await fetch( "http://localhost:5050/getNotifactions/" + store.state.userID, {
                    method: "get", 
                    headers: { "Content-Type": "application/json" },
                }).then((res) => {
                    return res.json();
                }).then((data) => {
                    console.log(data);
                    return data;
                });
                console.log("Notifications");
                console.log("Notifications response = " + response);
                context.commit('saveNotifications', response);
            /*} catch (error) {
                alert('error');
            }*/
        },
        getUsers: async context =>{
            //try {
                console.log('in store ' + store.state.userID);
                let response = [];
                response = await fetch( "http://localhost:5050/getUsers/" + store.state.userID , {
                    method: "get", 
                    headers: { "Content-Type": "application/json" },
                }).then((res) => {
                    return res.json();
                }).then((data) => {
                    console.log(data);
                    return data;
                })
                console.log("bbbbbbbbb");
                console.log("questions response = " + response);
                context.commit('saveUsers', response);
            /*} catch (error) {
                alert('error');
            }*/
        },
        getFollowers: async context =>{ 
            //try {
                console.log('in store ' + store.state.userID);
                let response = [];
                response = await fetch( "http://localhost:5050/getFollowers/" + store.state.userID + "/" + store.state.userName, {
                    method: "get", 
                    headers: { "Content-Type": "application/json" },
                }).then((res) => {
                    return res.json();
                }).then((data) => {
                    console.log(data);
                    return data;
                })
                console.log("bbbbbbbbb")
                console.log("Followers response = " + response);
                context.commit('saveFollowers', response);
            /*} catch (error) {
                alert('error');
            }*/
        },
        loadProfileData: async (context,_name) => { //not done yet
            //try {
                console.log('in store ' + store.state.userID);
                let response = [];
                response = await fetch( "http://localhost:5050/getProfileData/" + store.state.userID + "/" + _name , {
                    method: "get", 
                    headers: { "Content-Type": "application/json" },
                }).then((res) => {
                    return res.json();
                }).then((data) => {
                    console.log(data);
                    return data;
                })
                console.log("bbbbbbbbb")
                console.log("questions response = " + response);
                context.commit('saveProfileData', response);
            /*} catch (error) {
                alert('error');
            }*/
        },
        loadProfileQuestions: async (context,_name) => { //not done yet
            //try {
                console.log('in store ' + store.state.userID);
                let response = [];
                response = await fetch( "http://localhost:5050/getProfileQuestion/" + store.state.userID + "/" + _name , {
                    method: "get", 
                    headers: { "Content-Type": "application/json" },
                }).then((res) => {
                    return res.json();
                }).then((data) => {
                    console.log(data);
                    return data;
                })
                console.log("bbbbbbbbb")
                console.log("questions response = " + response);
                context.commit('saveProfileQuestions', response);
            /*} catch (error) {
                alert('error');
            }*/
        },
        loadHome: async context => { //not done yet
            //try {
                console.log('in store ' + store.state.userID);
                let response = [];
                response = await fetch( "http://localhost:5050/getHomeQuestion/" + store.state.userID + "/" + store.state.userName , {
                    method: "get", 
                    headers: { "Content-Type": "application/json" },
                }).then((res) => {
                    return res.json();
                }).then((data) => {
                    console.log(data);
                    return data;
                })
                console.log("bbbbbbbbb")
                console.log("home response = " + response);
                context.commit('saveHomeQuestions', response);
            /*} catch (error) {
                alert('error');
            }*/
        },
        like: (context,question_id) => {
            fetch(
                "http://localhost:5050/AddLike/" + store.state.userID + "/" + store.state.userName + "/" + question_id,
                {
                  method: "post",
                  headers: { "Content-Type": "application/json" },
                }
            );
        },
        unlike: (context,question_id) => {
            fetch(
                "http://localhost:5050/removeLike/" + store.state.userID + "/" + store.state.userName + "/" + question_id,
                {
                  method: "post",
                  headers: { "Content-Type": "application/json" },
                }
            );
        },
        loadSettings: async context => {
            //try {
                console.log('in store ' + store.state.userID);
                let response = [];
                response = await fetch( "http://localhost:5050/getSettings/" + store.state.userID + "/" + store.state.userName, {
                    method: "get", 
                    headers: { "Content-Type": "application/json" },
                }).then((res) => {
                    return res.json();
                }).then((data) => {
                    console.log(data);
                    return data;
                })
                console.log("Settings")
                console.log("Settings response = " + response);
                context.commit('saveSettings', response);
            /*} catch (error) {
                alert('error');
            }*/
        },
    },
    
});