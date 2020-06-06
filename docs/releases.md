# Current Releases

https://github.com/stefansjs/flatbuffers-intellij-plugin/releases

## Contributing

I don't really have a contribution guideline. I like to follow the golden rule of code style: follow conventions set out
in the code around you.

There is a lengthy process for creating release binaries below. The process is currently very manual, quite lengthy and 
almost entirely set out using github. Thanks github.


Feature development is done on master for as long as I am the only developer.
 
Pull requests may be done on feature branches and merged to release.
 
`release` is treated as a Release Candidate (RC) branch for testing in production environments. RC fixes are done 
directly on the release branch. QA iterations are done on release until a final release can be published. Releases are 
published and tagged on the release branch and merged back to master after releases are done.

## Release Process

This may be a living document. Each time you do a release make edits directly in that release's md file, and then come
back to update this template _after_ merging to master.

To create a release, start by checking out `release` and adding a new release markdown to `docs/releases/vX.Y.Z.md` with
the following markdown.

The follow the steps in the checklist

```markdown
# 

## Description

This release provides an initial version of a flatbuffers editing plugin for IntelliJ

## Checklist

- [ ] checkout the release branch
- [ ] merge origin/master
- [ ] create markdown file in `docs/releases/v<Release Number>.md` for the potential new release with the new version
 number
  - [ ] Update the markdown title with the upcoming version
  - [ ] Update the markdown body with a brief summary
  - [ ] Update the markdown description with release notes for the current release
- [ ] update plugin.xml with release notes
- [ ] update build.gradle with the RC version number (i.e. change alpha to beta)
- [ ] Push. Download the built artificat from github https://github.com/stefansjs/flatbuffers-intellij-plugin/actions?query=workflow%3Abuild
- [ ] create a new release candidate page on github using https://github.com/stefansjs/flatbuffers-intellij-plugin/releases/new
  - [ ] add a tag with the name `v<Release Number>-beta` following the release branch
  - [ ] Upload `flatbuffers-plugin-<Release Number>.zip` to the release page
  - [ ] Add a summary and description of features/bugfixes from the release .md file
  - [ ] Check the pre-release checkbox
  - [ ] Publish. Don't worry, you can continue to edit the release
- [ ] update the `updatePlugins.xml` to refer to the github asset url from 
      https://github.com/stefansjs/flatbuffers-intellij-plugin/releases 
- [ ] Test the plugin in an installed IDE
  - [ ] push to release
  - [ ] add https://github.com/stefansjs/flatbuffers-intellij-plugin/raw/release/updatePlugins.xml as a plugin repository
  - [ ] QA the updated plugin in the IDE
  - [ ] Make any necessary bugfix changes on the release branch
    - [ ] Push any necessary changes
    - [ ] update `updatePlugins.xml` with the new RC 
    - [ ] **Add** do **not delete** a new RC by executing the `buildPlugin` task and uploading it to the release
    - [ ] Repeat until Quality has been Assured
- [ ] Remove beta from the version string in build.gradle
- [ ] push to release
- [ ] Add the final binary to the github release
- [ ] Make a final release on github with the build artifact and publish it
- [ ] Publish the plugin on JetBrains Hub https://plugins.jetbrains.com/plugin/14326-flatbuffers-support
- [ ] merge to master
- [ ] Increment the version in build.gradle to the next alpha version
```
