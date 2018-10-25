import {GithubApiService} from './GithubApiService';
import * as _ from 'lodash';
import {Repo} from './Repo';

import {User} from './User';
let svc = new GithubApiService();
//svc.getUserInfo('dev-joseph');
/*
svc.getUserInfo('koushikkothagal', (user: User) => {
	console.log(user);
});
svc.getRepos('koushikkothagal', (repos: Repo[]) => {
	console.log(repos);
});*/

if (process.argv.length < 3) {
    console.log('Please pass the username as an argument');
}
else {
    let username = process.argv[2];
    svc.getUserInfo(username, (user: User) => {
        svc.getRepos(username, (repos: Repo[]) => {
            let sortedRepos = _.sortBy(repos, [(repo: Repo) => repo.forkCount * -1]);
            let filteredRepos = _.take(sortedRepos, 5);
            user.repos = filteredRepos;
            console.log(user);
        })
    })
}
