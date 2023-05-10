# Here is an example of using git revert in a Git repository:

## let's make some changes to the code
=>changes in revert.html file , i added a new paragraph

$ git add .

$ git commit -m "commit to be reverted"

## Oops, we made a mistake and want to revert this change
$ git log

commit 7f82cce36ff9c2b6cf20c6a8b6d96fa6f82fa6c7 (HEAD -> master)

Author: Merradou Abderrahmane <email@example.com>

Date:   Mon Jan 31 12:00:00 2022

commit to be reverted

commit 2f82cce36ff9c2b6cf20c6a8b6d96fa6f82fa6c7

Author: Merradou Abderrahmane <email@example.com>

Date:   Sun Jan 30 12:00:00 2022

save

$ git revert 7f82cce36ff9c2b6cf20c6a8b6d96fa6f82fa6c7

## This will create a new commit that reverses the changes in the previous commit
$ git log

commit 3f82cce36ff9c2b6cf20c6a8b6d96fa6f82fa6c7 (HEAD -> master)

Author: Merradou Abderrahmane <email@example.com>

Date:   Mon Jan 31 12:30:00 2022

Revert "commit to be reverted"

commit 2f82cce36ff9c2b6cf20c6a8b6d96fa6f82fa6c7

Author: Merradou Abderrahmane <email@example.com>

Date:   Sun Jan 30 12:00:00 2022

save