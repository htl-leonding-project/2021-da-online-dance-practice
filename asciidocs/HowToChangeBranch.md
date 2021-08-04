# Diplomarbeit "Online Perfektion"

- ACHTUNG: Wir verwenden main anstelle master als Hauptbranch

- Umstellen von Hauptbranch `master` auf Hauptbranch `main`
    - die lokale Git-Installation so konfigurieren, dass `main` der Hauptbranch ist
      ```
      git config --global init.defaultBranch main
      ```

    - den aktuellen `master` - Branch umbennen
      ```
      git branch -m main
      ```

    - push the new local `master`-branch and reset the upstream branch
      ```
      git push origin -u main
      ```

    - change the new `main` - branch to the default-branch in the repo host

      ![](images/change-default-branch-1.png)
      ![](images/change-default-branch-2.png)
      ![](images/change-default-branch-3.png)
      ![](images/change-default-branch-4.png)
      ![](images/change-default-branch-5.png)

    - delete the old `master` - branch
      ```
      git push origin --delete master
      ```

    - https://linuxize.com/post/how-to-rename-local-and-remote-git-branch/  

