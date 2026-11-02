# Upstream origin

This directory is a controlled copy of Voldeloom's build files and `src` tree.

- Repository: https://github.com/CrackedPolishedBlackstoneBricksMC/voldeloom
- Branch at investigation: `disaster-time`
- Commit: `da68a85cc6b5b6e336edd6f37db37f5b9657441e`
- Original group / plugin ID / version retained during P0.
- MIT notices remain in `LICENSE` and source headers; bundled LZMA notice remains in resources.

The read-only reference checkout stays in `research/voldeloom`. Make implementation
changes here, not in that checkout. No Minecraft binaries or generated sources
belong in version control.

## Local changes

- Add JUnit regression coverage for legacy FML sided member discovery.
- Emit runtime-visible `SideOnly` annotations for merged fields and methods.
  Forge .1345 `SideTransformer` reads only `visibleAnnotations`; the upstream
  runtime-invisible annotations leave client methods present on dedicated servers.
- Include the merge algorithm revision in cache properties to invalidate merged
  and downstream mapped outputs after this correction.
- P2: add opt-in per-SourceSet Mixin AP wiring, MCP/SRG mapping exports and
  explicit development refmap adaptation. Merge AP-generated member mappings
  into a fresh release mapping set with conflict/owner/descriptor diagnostics.
  The original plugin ID and other upstream task behavior are retained.
