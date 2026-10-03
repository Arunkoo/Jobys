import { MapPin, Search, SlidersHorizontal } from "lucide-react";
import type { FormEvent } from "react";
import { useAppContext } from "@/context/useAppContext";

export function JobSearchBar() {
  const { filters, updateFilters } = useAppContext();

  function handleSubmit(event: FormEvent<HTMLFormElement>) {
    event.preventDefault();
    document.querySelector("#jobs")?.scrollIntoView({ behavior: "smooth" });
  }

  return (
    <form
      onSubmit={handleSubmit}
      className="grid gap-1.5 border border-border bg-background p-1.5 md:grid-cols-[1.4fr_1fr_0.9fr_auto] md:items-center"
    >
      <label className="flex min-w-0 items-center gap-3 border-b border-border px-3 py-2 md:border-b-0 md:border-r">
        <Search className="shrink-0 text-muted-foreground" size={17} />
        <input
          value={filters.keyword}
          onChange={(event) => updateFilters({ keyword: event.target.value })}
          className="w-full bg-transparent text-sm outline-none placeholder:text-muted-foreground"
          placeholder="Job title, keyword or company"
          aria-label="Job title, keyword or company"
        />
      </label>
      <label className="flex min-w-0 items-center gap-3 border-b border-border px-3 py-2 md:border-b-0 md:border-r">
        <MapPin className="shrink-0 text-muted-foreground" size={17} />
        <input
          value={filters.location}
          onChange={(event) => updateFilters({ location: event.target.value })}
          className="w-full bg-transparent text-sm outline-none placeholder:text-muted-foreground"
          placeholder="Location or remote"
          aria-label="Location or remote"
        />
      </label>
      <label className="flex items-center gap-3 px-3 py-2.5">
        <SlidersHorizontal
          className="shrink-0 text-muted-foreground"
          size={18}
        />
        <select
          value={filters.type}
          onChange={(event) => updateFilters({ type: event.target.value })}
          className="w-full bg-transparent text-sm outline-none"
          aria-label="Job type"
        >
          <option>All job types</option>
          <option>Full-time</option>
          <option>Part-time</option>
          <option>Contract</option>
          <option>Internship</option>
        </select>
      </label>
      <button
        type="submit"
        className="bg-accent px-4 py-2.5 text-sm font-semibold text-accent-foreground transition-colors hover:bg-accent/90"
      >
        Search jobs
      </button>
    </form>
  );
}
